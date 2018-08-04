package com.server.service;


import com.server.model.User;

public interface IUserService {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return 用户信息string
     */
    public String selectUser(String username);

    /**
     * 插入用户
     * @param user
     * @return 插入成功boolean
     */
    public boolean insertUser(User user);

}