package com.hxyc.service;

import com.hxyc.model.User;

/**
 * Created by admin on 2020/1/4.
 */
public interface UserService {
    public User findByUsername(String username);
}
