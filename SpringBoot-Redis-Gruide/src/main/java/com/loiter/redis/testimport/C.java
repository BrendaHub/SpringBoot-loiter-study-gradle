package com.loiter.redis.testimport;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @Fun Description //TODO
 * @Date 2020/8/5 16:31 05
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
public class C {

    @Bean
    @ConditionalOnMissingBean(TestInfoA.class)
    public TestInfoC testInfoA() {
        return new TestInfoC();
    }
}
