package com.loiter.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Fun Description //TODO
 * @Date 2020/9/18 11:50 18
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/

@SpringBootApplication
@EnableAsync
public class EventDemoApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(EventDemoApplication.class);
        springApplication.run(args);

    }
}
