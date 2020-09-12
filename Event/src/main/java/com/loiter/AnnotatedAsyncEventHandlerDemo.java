package com.loiter;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 通过注解方法处理同步和异步事件发布
 */
@EnableAsync
public class AnnotatedAsyncEventHandlerDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(AnnotatedAsyncEventHandlerDemo.class);

        applicationContext.refresh();

        applicationContext.publishEvent(new MySpringEvent("Hello , World 注解"));

        applicationContext.close();
    }

    @Async // 同步 切换成 异步 特别注意， 这个注解使用是需有打开一个开关， 要激活异步开关 @EnableAsync
    @EventListener
    public void onEvent(MySpringEvent applicationEvent) {
        System.out.println("---");
        System.out.printf("[ 线程 ：%s]， onEvent方法调用 %s", Thread.currentThread().getName(), applicationEvent);
        System.out.println("----");
    }
}
