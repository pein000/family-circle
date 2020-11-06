package com.family.circle.api.service;

import com.family.circle.api.entity.UserPrimaryInfo;

import java.util.List;

/**
 * 主用户信息表(UserPrimaryInfo)表服务接口
 *
 * @author makejava
 * @since 2020-11-04 10:36:10
 */
public interface UserPrimaryInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserPrimaryInfo queryById(Long id);

}