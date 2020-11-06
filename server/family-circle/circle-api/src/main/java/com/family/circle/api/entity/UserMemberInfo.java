package com.family.circle.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 成员用户信息表(UserMemberInfo)实体类
 *
 * @author makejava
 * @since 2020-11-04 10:36:05
 */
@Data
public class UserMemberInfo implements Serializable {
    private static final long serialVersionUID = 654678616850468721L;
    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 成员用户名称
     */
    private String name;
    /**
     * 成员用户头像
     */
    private String avatar;
    /**
     * 主用户编号
     */
    private Long primaryUserId;
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