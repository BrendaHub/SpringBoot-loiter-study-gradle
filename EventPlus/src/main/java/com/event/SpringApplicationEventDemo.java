package com.event;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.*;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Iterator;

@EnableAsync
public class SpringApplicationEventDemo {
    public static void main(String[] args) {

//        GenericApplicationContext context = new GenericApplicationContext();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringApplicationEventDemo.class);

        // 基于接口的事情监听的写法
        // a 方法， 基于 ConfigableApplicationContext API 实现
        context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                printf(" Spring Application Context Event ");
            }
        });
        // b 方法 ，基于把ApplicationListener 注册成为一个 Spring Bean的方法
        // 是通过configtion 来注册成一个Bean 也可以监听到事件
        context.register(MyApplicationListener.class);
        context.refresh();
        context.start();
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        Iterator<String> beanNamesIterator = beanFactory.getBeanNamesIterator();
        System.out.println(beanNamesIterator.hasNext());
        context.close();

    }

    static class MyApplicationListener implements ApplicationListener<ApplicationContextEvent> {

        @Override
        public void onApplicationEvent(ApplicationContextEvent event) {
            printf("MyApplicationListener Event ");
        }
    }

    // 基于注解的方法获得springApplicationContextEvent
//    @EventListener
//    public  static  void annoEvent(ApplicationContextEvent event) {
//        printf("@EventListener Event is ");
//    }

    @EventListener
    @Order(1)
    public  static  void annoEvent1(ContextStartedEvent event) {
        printf("@EventListener 11111  ## ContextStartedEvent Event");
    }

    @EventListener
    @Order(3)
    public  static  void annoEvent2(ContextStartedEvent event) {
        printf("@EventListener 2222  ## ContextStartedEvent Event");
    }

    @EventListener
    @Order(2)
    @Async   // 通过异步来处理监听事情 ， 但是这里需要通过注解开启或叫激活异步处理机制 @EnableAsync
    public   void annoEventAsync(ContextStartedEvent event) {
        printf("@EventListener annoEventAsync22 ## ContextStartedEvent 异步 Event ");
    }


    @EventListener
    @Order(2)
    public  static  void annoEvent(ContextClosedEvent event) {
        printf("@EventListener annoEvent333 ## ContextClosedEvent Event ");
    }

    @EventListener
    public  static  void annoEvent(ContextRefreshedEvent event) {
        printf("@EventListener ## ContextRefreshedEvent Event ");
    }

    private static void printf(String message) {
        System.out.printf("[线程信息]- 名称： %s， 信息： %s", Thread.currentThread().getName(), message);
        System.out.println("-----");
    }

}
