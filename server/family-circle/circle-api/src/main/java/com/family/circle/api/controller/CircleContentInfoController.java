package com.family.circle.api.controller;

import com.family.circle.api.common.enumeration.ResponseCodeEnum;
import com.family.circle.api.common.util.ResponseHelper;
import com.family.circle.api.common.vo.request.CircleContentInfoRequest;
import com.family.circle.api.common.vo.response.CircleContentInfoResponse;
import com.family.circle.api.common.vo.response.CommonResponse;
import com.family.circle.api.entity.CircleContentInfo;
import com.family.circle.api.service.CircleContentInfoService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 圈子内容信息表(CircleContentInfo)表控制层
 *
 * @author makejava
 * @since 2020-10-29 10:59:37
 */
@CrossOrigin
@RestController
@RequestMapping("circleContentInfo")
@Slf4j
@Api(tags = "CircleContentInfoController")
public class CircleContentInfoController {
    /**
     * 服务对象
     */
    @Resource
    private CircleContentInfoService circleContentInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CircleContentInfo selectOne(Integer id) {
        return this.circleContentInfoService.queryById(id);
    }

    @PostMapping("selectPage")
    public CommonResponse<PageInfo<CircleContentInfoResponse>> selectPage(@RequestBody CircleContentInfoRequest request) {
        try {
            log.info("begin to selectPage. request: {}.", request);
            PageInfo<CircleContentInfoResponse> result = circleContentInfoService.queryPage(request.getPageNum(), request.getPageSize());
            log.info("end to selectPage. request: {}. result: {}.", request, result);
            return ResponseHelper.ofSuccess(result);
        } catch (Exception e) {
            log.info("failed to selectPage. request: {}.", request, e);
            return ResponseHelper.ofFail(ResponseCodeEnum.SYSTEM_LOADING);
        }
    }

}