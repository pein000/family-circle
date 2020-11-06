package com.family.circle.api.controller;

import com.family.circle.api.entity.UserPrimaryInfo;
import com.family.circle.api.service.UserPrimaryInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 主用户信息表(UserPrimaryInfo)表控制层
 *
 * @author makejava
 * @since 2020-11-04 10:36:10
 */
@RestController
@RequestMapping("userPrimaryInfo")
public class UserPrimaryInfoController {
    /**
     * 服务对象
     */
    @Resource
    private UserPrimaryInfoService userPrimaryInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserPrimaryInfo selectOne(Long id) {
        return this.userPrimaryInfoService.queryById(id);
    }

}