package com.family.circle.api.service;

import com.family.circle.api.entity.UserMemberInfo;

import java.util.List;

/**
 * 成员用户信息表(UserMemberInfo)表服务接口
 *
 * @author makejava
 * @since 2020-11-04 10:36:07
 */
public interface UserMemberInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserMemberInfo queryById(Long id);

}