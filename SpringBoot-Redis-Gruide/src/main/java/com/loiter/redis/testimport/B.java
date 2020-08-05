package com.loiter.redis.testimport;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisOperations;

/**
 * @Fun Description //TODO
 * @Date 2020/8/5 16:28 05
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
public class B {

    @Bean
    @ConditionalOnMissingBean(CommandLineRunner.class)
    public TestInfoB testInfoA() {
        return new TestInfoB();
    }
}

