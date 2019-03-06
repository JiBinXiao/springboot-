package com.xjb.data.provider.test.mapper;
import java.util.Date;

import com.xjb.data.api.model.User;
import com.xjb.data.provider.mapper.db1.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by xjb on 2019/2/27
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test1_Add() {
        User user=new User();

        user.setUsername("xjb");
        user.setPassword("123456");
        user.setCtime(new Date());
        user.setUtime(new Date());
        user.setSt(1);
        userMapper.insertSelective(user);
    }

    @Test
    public void test2_Query() {
        User user = userMapper.selectByPrimaryKey(1);
        Assert.assertNotNull(user);
    }



    @Test
    public void test4_Upd() {
        User user=new User();

        user.setUsername("xjb");
        user.setPassword("xjb");

        user.setUtime(new Date());
        user.setSt(1);
        int i = userMapper.updateByPrimaryKeySelective(user);
        Assert.assertEquals(1, i);
    }

    @Test
    public void test5_Del() {
        userMapper.deleteByPrimaryKey(1);

        Assert.assertEquals(null, userMapper.selectByPrimaryKey(1));
    }
}
