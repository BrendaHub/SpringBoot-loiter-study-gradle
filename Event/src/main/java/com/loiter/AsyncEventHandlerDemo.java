package com.loiter;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 异步事件处理器
 */
public class AsyncEventHandlerDemo {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();

        /// 1、 添加自定义 Spring 事件监听器
        context.addApplicationListener(new MySpringEventListener());

        // 2 、启动 Spring 应用上下文
        context.refresh(); // 在这一此Spring会初始化ApplicationEventMulticaster 这个实例用来发布事件

        // 2.1 这里就可以通过依赖查找得到ApplicationEventmulticaster对象
        ApplicationEventMulticaster applicationEventMulticaster =
                context.getBean(AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME,
                        ApplicationEventMulticaster.class);

        // 2.2 这里需要判断依赖查找得到的ApplicationEventMulticaster对象是不是SimpleApplicationEventMulticastoer对象
        if (applicationEventMulticaster instanceof SimpleApplicationEventMulticaster) {
            SimpleApplicationEventMulticaster simpleApplicationEventMulticaster =
                    (SimpleApplicationEventMulticaster) applicationEventMulticaster;
            // 2.2.1 切换taskExecutor
            // 2.2.2 改造
            ExecutorService executorService = Executors.newSingleThreadExecutor(
                    new CustomizableThreadFactory("my-spring-event-thread-pool")
            );
            simpleApplicationEventMulticaster.setTaskExecutor(executorService);

            // Executors创建的线程池是具有监听功能， 会阻碍主线程运行
            // 通过监听主线程ContextCloseEvent事件， 还同步关闭异步执行的线程池
            applicationEventMulticaster.addApplicationListener(new ApplicationListener<ContextClosedEvent>() {
                @Override
                public void onApplicationEvent(ContextClosedEvent event) {
                    // 注, 事件会进行父级传播， 所以这里建议进行判断， 避免会进行多次shutdown操作
                    if (!executorService.isShutdown()) {
                        executorService.shutdown();
                    }
                }
            });
        }

        // 3、 发布自定义Spring 事件
        context.publishEvent(new MySpringEvent("Hello, World"));

        // 4、 关闭 Spring 应用上下文
        context.close();

    }
}
