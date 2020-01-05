package com.hxyc.model;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author admin
 * @Date 2020/1/4 21:40
 **/
public class User implements Serializable{
    private Integer id;

    private String username;

    private String password;

    private String perms;

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}
