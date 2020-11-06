package com.family.circle.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.family.circle.api.common.enumeration.ChatMessageType;
import com.family.circle.api.common.vo.response.ChatContentInfoResponse;
import com.family.circle.api.entity.ChatContentInfo;
import com.family.circle.api.mapper.ChatContentInfoMapper;
import com.family.circle.api.service.ChatContentInfoService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 聊天内容信息表(ChatContentInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-11-04 10:46:29
 */
@Service("chatContentInfoService")
@Slf4j
public class ChatContentInfoServiceImpl implements ChatContentInfoService {
    @Resource
    private ChatContentInfoMapper chatContentInfoMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ChatContentInfo queryById(Long id) {
        return chatContentInfoMapper.selectById(id);
    }

    @Override
    public PageInfo<ChatContentInfoResponse> queryPage(Integer pageNum, Integer pageSize, Long primaryUserId) {
        log.info("begin to CircleContentInfo queryPage. pageNum:{}. pageSize:{}.primaryUserId:{}.", pageNum, pageSize, primaryUserId);
        Page<ChatContentInfo> result = chatContentInfoMapper.selectPage(new Page<>(pageNum, pageSize),
                new LambdaQueryWrapper<ChatContentInfo>()
                        .eq(ChatContentInfo::getPrimaryUserId, primaryUserId)
                        .orderByDesc(ChatContentInfo::getId));
        if (Objects.isNull(result)) {
            log.info("end to CircleContentInfo queryPage. pageNum:{}. pageSize:{}, primaryUserId:{}. result is null.", pageNum, pageSize, primaryUserId);
            return new PageInfo<>();
        }
        List<ChatContentInfoResponse> list = result.getRecords().stream().map(chatContentInfo -> {
            ChatContentInfoResponse response = new ChatContentInfoResponse();
            BeanUtils.copyProperties(chatContentInfo, response);
            return response;
        }).collect(Collectors.toList());
        log.info("end to CircleContentInfo queryPage. pageNum:{}. pageSize:{}, primaryUserId:{}. result size:{}.", pageNum, pageSize, primaryUserId, list.size());
        return new PageInfo<>(list);
    }

    @Override
    public ChatContentInfo insertOne(String message) {
        ChatContentInfo chatContentInfo = JSON.parseObject(message, ChatContentInfo.class);
        chatContentInfo.setType(ChatMessageType.TEXT.getType());
        int result = chatContentInfoMapper.insertOne(chatContentInfo);
        if(result > 0){
            return chatContentInfo;
        }
        return null;
    }
}