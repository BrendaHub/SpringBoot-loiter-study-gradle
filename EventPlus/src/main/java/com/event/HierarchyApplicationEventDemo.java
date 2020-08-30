package com.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 层次性spring事件处理器
 */
@EnableAsync
public class HierarchyApplicationEventDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext parentContext = new AnnotationConfigApplicationContext();
        parentContext.setId("parent-context");
        parentContext.register(MyListener.class);

        AnnotationConfigApplicationContext currentContext = new AnnotationConfigApplicationContext();
        currentContext.setId("currentContent-context");
        currentContext.setParent(parentContext);
        currentContext.register(MyListener.class);

        parentContext.refresh();

        currentContext.refresh();

        currentContext.close();
        parentContext.close();


    }

    static class MyListener implements ApplicationListener<ApplicationContextEvent> {

        // 这里会出现父子层次性的事情处理机制， 导致相同的事情会运行多次，
        // 如何进行过滤去重操作，一个简单的思路就是把获取到的事件通过一个容器加以过滤去重，确保同一个事情正常处理一次。

        // 第一次事情过滤去重机制
        static private Set<ApplicationContextEvent> set = new LinkedHashSet<>();
        @Override
        @Async
        public void onApplicationEvent(ApplicationContextEvent event) {

            // 这样处理后 就会让事情触发比较正常化了。
            if(set.add(event)) {
                System.out.printf("监听事件， 当前 进程为 %s ， 对应事情为 %s", event.getApplicationContext().getId(),
                        event.getClass().getSimpleName());
                System.out.println("---");
            }
        }
    }
}
