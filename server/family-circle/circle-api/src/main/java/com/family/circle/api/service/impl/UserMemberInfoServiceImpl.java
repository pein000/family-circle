package com.family.circle.api.service.impl;

import com.family.circle.api.entity.UserMemberInfo;
import com.family.circle.api.mapper.UserMemberInfoMapper;
import com.family.circle.api.service.UserMemberInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 成员用户信息表(UserMemberInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-11-04 10:36:08
 */
@Service("userMemberInfoService")
public class UserMemberInfoServiceImpl implements UserMemberInfoService {
    @Resource
    private UserMemberInfoMapper userMemberInfoMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserMemberInfo queryById(Long id) {
        return this.userMemberInfoMapper.selectById(id);
    }

}