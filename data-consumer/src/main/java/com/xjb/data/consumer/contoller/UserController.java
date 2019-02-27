package com.xjb.data.consumer.contoller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjb.data.api.model.User;
import com.xjb.data.api.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by xjb on 2019/2/25
 **/
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Reference(version = "1.0.0")
    UserService userService;

    @RequestMapping(value = "/sayHello")
    public String sayHello(@RequestParam(defaultValue = "xjb") String name){
        return userService.sayHello(name);
    }

    @RequestMapping(value = "add")
    public String add(User user){
        user.setCtime(new Date());
        user.setUtime(new Date());
        userService.add(user);
        return "add success";
    }

    @RequestMapping(value = "findById")
    public User findById(int id){
        return userService.findById(id);
    }

    @RequestMapping(value = "update")
    public String update(User user){
        user.setUtime(new Date());
        userService.update(user);
        return "update success";
    }

    @RequestMapping(value = "delById")
    public String delById(int id){
        userService.delById(id);
        return "delete success";
    }
}
