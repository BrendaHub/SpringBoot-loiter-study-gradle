package com.loiter.redis.testimport;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Fun Description //TODO
 * @Date 2020/8/5 17:28 05
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
@Component
public class E {

    public String say(){
        System.out.println("Say Hello");
        return "Hello";
    }
}
