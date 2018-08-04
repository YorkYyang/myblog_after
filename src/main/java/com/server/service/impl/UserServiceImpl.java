package com.server.service.impl;


import com.server.dao.IUserDao;
import com.server.model.User;
import com.server.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public String selectUser(String username) {
        return this.userDao.selectUser(username);
    }

    @Override
    public boolean insertUser(User user) {
        int result = this.userDao.insertUser(user);
        if (result == -1)
        {
            return false;
        }
        else{
            return true;
        }
    }
}