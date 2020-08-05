package com.loiter.google.pojo;

import java.io.Serializable;

/**
 * @Fun Description //TODO
 * @Date 2020/8/5 18:42 05
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
public class User implements Serializable {
    private String userName;
    private String userId;

    public User(String userName, String userId) {
        this.userName = userName;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return userId + " --- " + userName;
    }

}
