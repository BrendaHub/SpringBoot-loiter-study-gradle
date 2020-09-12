package com.loiter;

import org.springframework.context.ApplicationListener;

public class MySpringEventListener implements ApplicationListener<MySpringEvent> {


    @Override
    public void onApplicationEvent(MySpringEvent event) {
        System.out.printf("[线程： %s]： %s", Thread.currentThread().getName(), event);
    }
}
