package com.xjb.data.consumer.contoller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xjb.data.api.common.model.RtnResult;
import com.xjb.data.api.model.User;
import com.xjb.data.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value = "/sayHello")
    public String sayHello(@RequestParam(defaultValue = "xjb") String name) {
        return userService.sayHello(name);
    }

    @ApiOperation("新增用户")
    @RequestMapping(value = "add")
    public RtnResult add(User user) {
        user.setCtime(new Date());
        user.setUtime(new Date());
        userService.add(user);
        log.info("User id {} add success => {}", user.getId(), user.toString());
        return RtnResult.successInfo("add success");
    }

    @ApiOperation("根据id查询用户")
    @RequestMapping(value = "findById")
    public RtnResult<User> findById(@ApiParam(value = "用户id", example = "1", required = true) @RequestParam(required = true) int id) {
        User user = userService.findById(id);
        log.info("User id {} find success => {}", user.getId(), user.toString());
        return RtnResult.successInfo(user);
    }

    @ApiOperation("根据id更新用户")
    @RequestMapping(value = "update")
    public RtnResult update(User user) {
        user.setUtime(new Date());
        userService.update(user);
        log.info("User id {} update success => {}", user.getId(), user.toString());
        return RtnResult.successInfo("update success");
    }

    @ApiOperation("根据id删除用户")
    @RequestMapping(value = "delById")
    public RtnResult delById(int id) {
        userService.delById(id);
        log.info("User id {} update success => ", id);
        return RtnResult.successInfo("delete success");
    }
}
