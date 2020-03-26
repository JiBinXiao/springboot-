package com.xjb.data.api.service;

import com.xjb.data.api.model.LoggerEntity;

/**
 * @author: xjb
 * @date: 2020/3/26
 * @description: 日志
 **/
public interface LoggerService {
    public int insertSelective(LoggerEntity loggerEntity);


}
