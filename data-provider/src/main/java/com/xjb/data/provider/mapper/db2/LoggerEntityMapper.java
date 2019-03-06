package com.xjb.data.provider.mapper.db2;

import com.xjb.data.api.model.LoggerEntity;


public interface LoggerEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LoggerEntity record);

    int insertSelective(LoggerEntity record);

    LoggerEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LoggerEntity record);

    int updateByPrimaryKey(LoggerEntity record);
}