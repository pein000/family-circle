package com.family.circle.api.service;

import com.family.circle.api.common.vo.response.ChatContentInfoResponse;
import com.family.circle.api.common.vo.response.CircleContentInfoResponse;
import com.family.circle.api.entity.ChatContentInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 聊天内容信息表(ChatContentInfo)表服务接口
 *
 * @author makejava
 * @since 2020-11-04 10:46:29
 */
@Service
public interface ChatContentInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ChatContentInfo queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param pageNum 分页游标
     * @param pageSize  分页大小
     * @return 对象列表
     */
    PageInfo<ChatContentInfoResponse> queryPage(Integer pageNum, Integer pageSize, Long primaryUserId);

    /**
     * 写入数据
     * @param message
     * @return
     */
    ChatContentInfo insertOne(String message);

}