package com.xjb.data.api.service;

import com.xjb.data.api.model.User;

/**
 * Created by xjb on 2019/2/25
 **/
public interface UserService {

    public String sayHello(String name);

    /**
     * 根据id查询User
     * @param id
     * @return
     */
    User findById(int id);

    /**
     * 根据id删除User
     * @param id
     * @return
     */
    int delById(int id);

    /**
     * 新增User
     * @param user
     * @return
     */
    int add(User user);

    /**
     * 更新User
     * @param user
     * @return
     */
    int update(User user);
}
