package com.family.circle.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.sun.javafx.beans.IDProperty;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import java.io.Serializable;
import java.util.Date;

/**
 * 圈子内容信息表(CircleContentInfo)实体类
 *
 * @author makejava
 * @since 2020-10-29 10:59:34
 */
@Data
public class CircleContentInfo {
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
    private Long familyUserId;
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
    private String memberUserAvator;
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
    private Object isRemoved;

}