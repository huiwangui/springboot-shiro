package com.hxyc.model;

import java.io.Serializable;

/**
 * @ClassName Cron
 * @Description TODO
 * @Author admin
 * @Date 2020/1/5 18:28
 **/
public class Cron implements Serializable{
    private Integer id;

    private String cron;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron == null ? null : cron.trim();
    }
}
