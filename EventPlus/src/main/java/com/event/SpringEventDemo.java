package com.event;

import com.google.gson.Gson;
import com.google.gson.internal.bind.util.ISO8601Utils;
import org.springframework.context.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 研究Spring是如何通过ApplicationEventPublicsher发布事情监听， 这里演示如何通过ApplicationEventPublisherAware 获到到Publisher对象
 */
@EnableAsync
public class SpringEventDemo implements ApplicationEventPublisherAware {
    static Gson gson = new Gson();
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // ApplicationContext Register 需要在refresh之前；
        context.register(SpringEventDemo.class);
        context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                printf(" SpringEventDemo Event " + gson.toJson(event));
                if(event instanceof  PayloadApplicationEvent) {
                    Object object = ((PayloadApplicationEvent) event).getPayload();
                    if (object instanceof User) {
                        System.out.println("================");
                        System.out.println(((User) object).getUserName());
                        System.out.println(((User) object).getPassword());
                        System.out.println(dtf.format(((User) object).getLocalDateTime()));
                        System.out.println("=================");
                    }
                }
            }
        });
//        context.register(MyApplicationListener.class);
        context.refresh();


        context.close();
    }

    @Override
    @Async
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        // 这里获到了applicationEventPublisher 就可以发布事件了。
        applicationEventPublisher.publishEvent(new ApplicationEvent("Hello, World!") {
        });
        // 还有一个方式可以发布一个更通用的事情描述
        applicationEventPublisher.publishEvent("Hello， World，Object Event ");
        // 注意， 这里自定义了一个PayLoadApplicationEvent的子类， 会报出如下异常：
        // failed; nested exception is java.lang.IllegalArgumentException: Mismatched number of generics specified
//        applicationEventPublisher.publishEvent(new MyPayloadApplicationEvent(this, "Hello, PayLoadEvent! "));
        // 所以在实际开发中可以直接通过PayloadApplicationEvent发相关的事情，带payload的事件
        applicationEventPublisher.publishEvent(new PayloadApplicationEvent<String>(this,"hello， payloadApplicationEvent"));
        // 通过PayLoadApplicationEvent发布一个自定认对象的事件
        // 注意， 实际工作中这种发事情不建议使用， 建议直接调用applicationEventPublisher 的publishEvent(Object event)方法， 这个他底层就会包装成为一个payloadApplicationEventc对象
        applicationEventPublisher.publishEvent(new PayloadApplicationEvent<User>(this, new User("Python", "123", LocalDateTime.now())));
        // 建议调用方法
        applicationEventPublisher.publishEvent(new User("JavaApplicationEvent", "234", LocalDateTime.now()));

    }
    // 如果这里添加 generics 的defined 就不会报错了。
    @Deprecated
    static class MyPayloadApplicationEvent<String> extends PayloadApplicationEvent<String> {

        /**
         * Create a new PayloadApplicationEvent.
         *
         * @param source  the object on which the event initially occurred (never {@code null})
         * @param payload the payload object (never {@code null})
         */
        @Deprecated
        public MyPayloadApplicationEvent(Object source, String payload) {
            super(source, payload);
        }
    }

    static class MyApplicationListener implements ApplicationListener<ApplicationContextEvent> {

        @Override
        @Async
        public void onApplicationEvent(ApplicationContextEvent event) {
            printf("MyApplicationListener Event " + gson.toJson(event));
        }
    }

    private static void printf(String message) {
        System.out.printf("[线程信息]- 名称： %s， 信息： %s", Thread.currentThread().getName(), message);
        System.out.println("-----");
    }

    class User{
        private String userName;
        private String password;
        private LocalDateTime localDateTime;


        @Override
        public String toString() {
            return "User{" +
                    "userName='" + userName + '\'' +
                    ", password='" + password + '\'' +
                    ", localDateTime=" + localDateTime +
                    '}';
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public LocalDateTime getLocalDateTime() {
            return localDateTime;
        }

        public void setLocalDateTime(LocalDateTime localDateTime) {
            this.localDateTime = localDateTime;
        }

        public User() {
        }

        public User(String userName, String password, LocalDateTime localDateTime) {
            this.userName = userName;
            this.password = password;
            this.localDateTime = localDateTime;
        }
    }
}
