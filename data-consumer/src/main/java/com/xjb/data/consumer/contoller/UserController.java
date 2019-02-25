package com.xjb.data.consumer.contoller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjb.data.api.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
