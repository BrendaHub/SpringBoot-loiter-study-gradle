package com.loiter;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义Spring事件类
 */
public class MySpringEvent extends ApplicationEvent {
    public MySpringEvent(String s) {
        super(String.format("[线程： %s] ： %s", Thread.currentThread().getName(), s));
    }

    @Override
    public String getSource() {
        return (String)super.getSource();
    }

    public String getMessage() {
        return getSource();
    }
}
