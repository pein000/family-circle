package com.family.circle.api.service;

import com.family.circle.api.common.vo.response.CircleContentInfoResponse;
import com.family.circle.api.entity.CircleContentInfo;
import com.github.pagehelper.PageInfo;


/**
 * 圈子内容信息表(CircleContentInfo)表服务接口
 *
 * @author makejava
 * @since 2020-10-29 10:59:36
 */
public interface CircleContentInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CircleContentInfo queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param pageNum 分页游标
     * @param pageSize  分页大小
     * @return 对象列表
     */
    PageInfo<CircleContentInfoResponse> queryPage(Integer pageNum, Integer pageSize);

}