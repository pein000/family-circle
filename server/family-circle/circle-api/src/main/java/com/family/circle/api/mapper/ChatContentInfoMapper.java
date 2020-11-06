package com.family.circle.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.family.circle.api.entity.ChatContentInfo;

/**
 * 聊天内容信息表(ChatContentInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-04 10:46:28
 */
public interface ChatContentInfoMapper extends BaseMapper<ChatContentInfo> {

    int insertOne(ChatContentInfo chatContentInfo);

}