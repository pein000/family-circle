package com.family.circle.api.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class WechatConfig {

    @Value("${wechat.app.id:wxc0e27c714c2ec863}")
    private String wechatAppId;

    @Value("${wechat.app.secret:eebbc8bd085a2519f63af4bdc67025a0}")
    private String wechatAppSecret;

    @Value("${wechat.url.login:https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code}")
    private String wechatUrlLogin;
}
