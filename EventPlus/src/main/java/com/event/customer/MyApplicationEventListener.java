package com.event.customer;

import com.google.gson.Gson;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 自定义一个事件监听的listener
 */
public class MyApplicationEventListener implements ApplicationListener<MySpringEvent> {
    Gson gson = new Gson();

    @Override
    public void onApplicationEvent(MySpringEvent event) {
        System.out.printf("[线程： %s] 监听到的事件： %s \n", Thread.currentThread().getName(), gson.toJson(event));

    }
}
