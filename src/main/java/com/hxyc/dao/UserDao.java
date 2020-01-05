package com.hxyc.dao;

import com.hxyc.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by admin on 2020/1/4.
 */

public interface UserDao {

    public User findByUsername(String username);
}
