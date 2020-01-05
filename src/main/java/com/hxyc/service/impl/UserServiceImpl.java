package com.hxyc.service.impl;

import com.hxyc.dao.UserDao;
import com.hxyc.model.User;
import com.hxyc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author admin
 * @Date 2020/1/4 21:54
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserDao userDao;


    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
