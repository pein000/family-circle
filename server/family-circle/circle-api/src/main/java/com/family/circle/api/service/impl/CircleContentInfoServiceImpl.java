package com.family.circle.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.family.circle.api.common.vo.response.CircleContentInfoResponse;
import com.family.circle.api.mapper.CircleContentInfoMapper;
import com.family.circle.api.entity.CircleContentInfo;
import com.family.circle.api.service.CircleContentInfoService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 圈子内容信息表(CircleContentInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-10-29 10:59:37
 */
@Service("circleContentInfoService")
@Slf4j
public class CircleContentInfoServiceImpl implements CircleContentInfoService {

    @Resource
    private CircleContentInfoMapper circleContentInfoMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CircleContentInfo queryById(Integer id) {
        return this.circleContentInfoMapper.selectById(id);
    }


    @Override
    public PageInfo<CircleContentInfoResponse> queryPage(Integer pageNum, Integer pageSize) {
        log.info("begin to queryPage. pageNum:{}. pageSize:{}.", pageNum, pageSize);
        Page<CircleContentInfo> result = circleContentInfoMapper.selectPage(new Page<>(pageNum, pageSize), new LambdaQueryWrapper<CircleContentInfo>().orderByAsc(CircleContentInfo::getId));
        if (Objects.isNull(result)) {
            log.info("end to queryPage. pageNum:{}. pageSize:{}, result is null.", pageNum, pageSize);
            return new PageInfo<>();
        }
        List<CircleContentInfoResponse> list = result.getRecords().stream().map(circleContentInfo -> {
            CircleContentInfoResponse response = new CircleContentInfoResponse();
            BeanUtils.copyProperties(circleContentInfo, response);
            return response;
        }).collect(Collectors.toList());
        log.info("end to queryPage. pageNum:{}. pageSize:{}, result size:{}.", pageNum, pageSize, list.size());
        return new PageInfo<>(list);
    }

}