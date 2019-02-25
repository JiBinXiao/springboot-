package com.xjb.data.provider.service.imp;


import com.alibaba.dubbo.config.annotation.Service;
import com.xjb.data.api.service.UserService;

/**
 * Created by xjb on 2019/2/25
 **/
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {
    @Override
    public String sayHello(String name) {
        return "您好，"+name+"!";
    }
}
