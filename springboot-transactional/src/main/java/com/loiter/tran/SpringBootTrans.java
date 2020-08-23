package com.loiter.tran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTrans {
    public static void main(String[] args) {
        //https://github.com/xuwujing/springBoot-study/blob/master/springboot-transactional/pom.xml
        SpringApplication.run(SpringBootTrans.class, args);
        System.out.println("Hello World");
    }
}
