package com.xjb.data.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjb.data.api.common.model.RtnResult;
import com.xjb.data.api.model.User;
import com.xjb.data.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by xjb on 2019/2/25
 **/
@Api(tags = "用户管理控制类")
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @Reference(version = "1.0.0")
    UserService userService;


    @ApiOperation("测试")
    @GetMapping(value = "/sayHello")
    public String sayHello(@RequestParam(defaultValue = "xjb") String name) {
        return userService.sayHello(name);
    }

    @ApiOperation("新增用户")
    @PostMapping(value = "add")
    public RtnResult add(User user) {
        user.setCtime(new Date());
        user.setUtime(new Date());
        userService.add(user);
        log.info("User id {} add success => {}", user.getId(), user.toString());
        return RtnResult.successInfo(user.getId());
    }

    @ApiOperation("根据id查询用户")
    @GetMapping(value = "findById")
    public RtnResult<User> findById(@ApiParam(value = "用户id", example = "1", required = true) @RequestParam(required = true) int id) {
        User user = userService.findById(id);
        if (user != null)
            log.info("User id {} find success => {}", user.getId(), user.toString());
        return RtnResult.successInfo(user);
    }

    @ApiOperation("根据id更新用户")
    @PutMapping(value = "update")
    public RtnResult update(User user) {
        user.setUtime(new Date());
        userService.update(user);
        if (user != null)
            log.info("User id {} update success => {}", user.getId(), user.toString());
        return RtnResult.successInfo("update success");
    }

    @ApiOperation("根据id删除用户")
    @DeleteMapping(value = "delById")
    public RtnResult delById(int id) {
        userService.delById(id);
        log.info("User id {} update success => ", id);
        return RtnResult.successInfo("delete success");
    }
}
