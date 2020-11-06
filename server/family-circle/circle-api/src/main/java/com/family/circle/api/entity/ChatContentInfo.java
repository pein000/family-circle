package com.family.circle.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 聊天内容信息表(ChatContentInfo)实体类
 *
 * @author makejava
 * @since 2020-11-04 10:46:27
 */
@Data
public class ChatContentInfo implements Serializable {
    private static final long serialVersionUID = 402615828184830562L;
    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 图片内容
     */
    private String content;
    /**
     * 0:文本 1：表情 2：图片 3：视频 4:其他
     */
    private Integer type;
    /**
     * 成员用户编号
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
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 0:使用中，1：已删除
     */
    private Integer isRemoved;


}