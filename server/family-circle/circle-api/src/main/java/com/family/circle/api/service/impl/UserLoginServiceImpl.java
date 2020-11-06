package com.family.circle.api.service.impl;

import com.family.circle.api.common.dto.CodeToSessionResult;
import com.family.circle.api.config.WechatConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserLoginServiceImpl {

    private final static String APPID = "APPID";
    private final static String SECRET = "SECRET";
    private final static String JSCODE = "JSCODE";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WechatConfig wechatConfig;

    public void code2Session(String code) {
        String url = wechatConfig.getWechatUrlLogin();
        String target = url.replace(APPID, wechatConfig.getWechatAppId())
                .replace(SECRET, wechatConfig.getWechatAppSecret())
                .replace(JSCODE, code);
        CodeToSessionResult result = restTemplate.getForObject(target, CodeToSessionResult.class);
        if (result.isSuccess()) {
            String openId = result.getOpenid();
        }
    }

}
