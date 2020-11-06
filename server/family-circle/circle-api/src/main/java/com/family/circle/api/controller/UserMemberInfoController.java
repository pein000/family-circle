package com.family.circle.api.controller;

import com.family.circle.api.entity.UserMemberInfo;
import com.family.circle.api.service.UserMemberInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 成员用户信息表(UserMemberInfo)表控制层
 *
 * @author makejava
 * @since 2020-11-04 10:36:08
 */
@RestController
@RequestMapping("userMemberInfo")
public class UserMemberInfoController {
    /**
     * 服务对象
     */
    @Resource
    private UserMemberInfoService userMemberInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserMemberInfo selectOne(Long id) {
        return this.userMemberInfoService.queryById(id);
    }

}