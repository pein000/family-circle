package com.family.circle.api.service.impl;

import com.family.circle.api.entity.UserPrimaryInfo;
import com.family.circle.api.mapper.UserPrimaryInfoMapper;
import com.family.circle.api.service.UserPrimaryInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 主用户信息表(UserPrimaryInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-11-04 10:36:10
 */
@Service("userPrimaryInfoService")
public class UserPrimaryInfoServiceImpl implements UserPrimaryInfoService {
    @Resource
    private UserPrimaryInfoMapper userPrimaryInfoMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserPrimaryInfo queryById(Long id) {
        return this.userPrimaryInfoMapper.selectById(id);
    }


}