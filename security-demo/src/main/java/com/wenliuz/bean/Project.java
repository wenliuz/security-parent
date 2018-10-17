package com.wenliuz.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by wenliu on 2018/10/16.
 */
public class Project {

    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss",timezone = "GMT+8")
    private Date time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
