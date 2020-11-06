package com.family.circle.api.common.vo.response;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class CircleContentInfoResponse {

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Integer id;
    /**
     * 标题
     */
    private String circleTitle;
    /**
     * 图片内容
     */
    private String imageContent;
    /**
     * 文本内容
     */
    private String textContent;
    /**
     * 家庭用户编号
     */
    private Long primaryUserId;
    /**
     * 成员用户编号
     */
    private Long memberUserId;
    /**
     * 成员用户名称
     */
    private String memberUserName;
    /**
     * 成员用户头像
     */
    private String memberUserAvatar;
    /**
     * 创建时间
     */
    private Date createTime;

}
