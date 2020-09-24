package com.loiter.events;

/**
 * @Fun Description //TODO
 * @Date 2020/9/18 12:14 18
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
public class UserRemoveEvent {

    public String name;

    public UserRemoveEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
