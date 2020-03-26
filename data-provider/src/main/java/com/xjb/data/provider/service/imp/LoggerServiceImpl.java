package com.xjb.data.provider.service.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.xjb.data.api.model.LoggerEntity;
import com.xjb.data.api.service.LoggerService;
import com.xjb.data.provider.mapper.db2.LoggerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: xjb
 * @date: 2020/3/26
 * @description:
 **/
@Service(version = "1.0.0")
public class LoggerServiceImpl implements LoggerService {


    @Autowired
    LoggerEntityMapper loggerEntityMapper;

    public int insertSelective(LoggerEntity loggerEntity) {
        return loggerEntityMapper.insertSelective(loggerEntity);
    }


}
