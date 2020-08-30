package com.event.customer;


import com.google.gson.Gson;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * 自定义Spring Event
 */
public class MySpringEventDemo implements ApplicationEventPublisherAware {
    static Gson gson = new Gson();

    public static void main(String[] args) {
//        GenericApplicationContext applicationContext = new GenericApplicationContext();
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(MySpringEventDemo.class);
        // 这个应用上下文是不需要注册bean的
        // 自定义spring event 第三步，注册自定义的listener
        applicationContext.addApplicationListener(new MyApplicationEventListener());
        applicationContext.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.out.printf("[Main线程： %s] 监听到的事件： %s \n", Thread.currentThread().getName(), event);
            }
        });
        applicationContext.refresh();
        // 这里需要发起事件
        applicationContext.publishEvent(new MySpringEvent("Hello MySpringEvent "));
        applicationContext.close();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        applicationEventPublisher.publishEvent(new MySpringEvent("Hello, ApplicationEventPublisherAware "));
//        applicationEventPublisher.publishEvent("Hello, p");
    }
}
