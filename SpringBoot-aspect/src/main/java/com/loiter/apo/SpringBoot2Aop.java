package com.loiter.apo;

import com.loiter.apo.pojo.Employee;
import com.loiter.beans.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot2Aop {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2Aop.class, args);
        System.out.println("启动成功");
    }
}
