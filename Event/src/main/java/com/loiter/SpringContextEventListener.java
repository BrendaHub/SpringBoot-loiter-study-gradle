package com.loiter;


import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.GenericApplicationContext;

/**
 * SpringContext 与  SpringContextListener 的关系
 * {@link org.springframework.context.ApplicationListener}
 */
public class SpringContextEventListener {

    public static void main(String[] args){
        GenericApplicationContext context = new GenericApplicationContext();

        context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.out.println("spring application Event is " + event);
            }
        });

        System.out.println("OK");
        // 启动 SPRING 应用上下文
        context.refresh();
        // 关闭 Spring 应用上下文
        context.close();
    }
}
