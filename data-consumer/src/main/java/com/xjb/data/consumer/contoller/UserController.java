package com.xjb.data.consumer.contoller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjb.data.api.model.User;
import com.xjb.data.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by xjb on 2019/2/25
 **/
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    @Reference(version = "1.0.0")
    UserService userService;

    @RequestMapping(value = "/sayHello")
    public String sayHello(@RequestParam(defaultValue = "xjb") String name) {
        return userService.sayHello(name);
    }

    @RequestMapping(value = "add")
    public String add(User user) {
        user.setCtime(new Date());
        user.setUtime(new Date());
        userService.add(user);
        log.info("User id {} add success => {}",user.getId(), user.toString());
        return "add success";
    }

    @RequestMapping(value = "findById")
    public User findById(int id) {
        User user=userService.findById(id);
        log.info("User id {} find success => {}",user.getId(), user.toString());
        return user;
    }

    @RequestMapping(value = "update")
    public String update(User user) {
        user.setUtime(new Date());
        userService.update(user);
        log.info("User id {} update success => {}",user.getId(), user.toString());
        return "update success";
    }

    @RequestMapping(value = "delById")
    public String delById(int id) {
        userService.delById(id);
        log.info("User id {} update success => ",id);
        return "delete success";
    }
}
