package com.xjb.data.provider.service.imp;


import com.alibaba.dubbo.config.annotation.Service;
import com.xjb.data.api.model.User;
import com.xjb.data.api.service.UserService;
import com.xjb.data.provider.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by xjb on 2019/2/25
 **/
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public String sayHello(String name) {
        return "您好，"+name+"!";
    }

    @Override
    public User findById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delById(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
