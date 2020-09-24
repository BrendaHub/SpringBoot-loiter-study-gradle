package com.loiter.events;

import org.springframework.context.ApplicationEvent;

/**
 * @Fun Description //TODO
 * @Date 2020/9/18 12:09 18
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
public class UserCreateEvent extends ApplicationEvent {


    private static final long serialVersionUID = -2662931540330493587L;
    private String name;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public UserCreateEvent(Object source) {
        super(source);
    }

    public UserCreateEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
