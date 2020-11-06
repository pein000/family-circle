package com.family.circle.api.controller;

import com.family.circle.api.common.enumeration.ResponseCodeEnum;
import com.family.circle.api.common.util.ResponseHelper;
import com.family.circle.api.common.vo.request.CircleContentInfoRequest;
import com.family.circle.api.common.vo.response.ChatContentInfoResponse;
import com.family.circle.api.common.vo.response.CircleContentInfoResponse;
import com.family.circle.api.common.vo.response.CommonResponse;
import com.family.circle.api.entity.ChatContentInfo;
import com.family.circle.api.service.ChatContentInfoService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 聊天内容信息表(ChatContentInfo)表控制层
 *
 * @author makejava
 * @since 2020-11-04 10:46:30
 */
@CrossOrigin
@RestController
@RequestMapping("chatContentInfo")
@Slf4j
@Api(tags = "ChatContentInfoController")
public class ChatContentInfoController {
    /**
     * 服务对象
     */
    @Resource
    private ChatContentInfoService chatContentInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ChatContentInfo selectOne(Long id) {
        return this.chatContentInfoService.queryById(id);
    }

    @PostMapping("selectPage")
    public CommonResponse<PageInfo<ChatContentInfoResponse>> selectPage(@RequestBody CircleContentInfoRequest request) {
        try {
            log.info("begin to chatContentInfo selectPage. request: {}.", request);
            PageInfo<ChatContentInfoResponse> result = chatContentInfoService.queryPage(request.getPageNum(), request.getPageSize(), request.getPrimaryUserId());
            log.info("end to chatContentInfo selectPage. request: {}. result: {}.", request, result);
            return ResponseHelper.ofSuccess(result);
        } catch (Exception e) {
            log.info("failed to chatContentInfo selectPage. request: {}.", request, e);
            return ResponseHelper.ofFail(ResponseCodeEnum.SYSTEM_LOADING);
        }
    }

}