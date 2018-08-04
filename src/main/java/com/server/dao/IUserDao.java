package com.server.dao;


import com.server.model.User;

public interface IUserDao {

    String selectUser(String useranme);

    int insertUser(User user);
}