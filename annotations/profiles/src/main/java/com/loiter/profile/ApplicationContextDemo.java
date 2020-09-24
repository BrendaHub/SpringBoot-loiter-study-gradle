package com.loiter.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;

@ComponentScan(basePackages = "com.loiter.*")
public class ApplicationContextDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ApplicationContextDemo.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        environment.setDefaultProfiles("even"); // 这个profile是个兜底的profile配置

//        environment.setActiveProfiles("odd"); // 这个配置的profile优先级高于 deaultProfiles 配置
        environment.addActiveProfile("odd");
        applicationContext.refresh();

        Integer number = applicationContext.getBean("number", Integer.class);
        System.out.println(number);

        applicationContext.close();
    }
}
