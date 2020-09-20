package com.loiter.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.util.Assert;

import java.math.BigDecimal;

/**
 *  profiles Demo
 *  {@link org.springframework.context.annotation.Profile} profile
 */

@Configuration
public class ProfileDemo {

    @Bean(value = "number")
    @Profile(value = "odd")
    public Integer odd() {
        return 1;
    }

    @Bean("number")
//    @Profile("even")  // 这是一个定义bean的profile的方式
    @Conditional(EnvironmentConditionProfile.class)
    public Integer even() {
        return 2;
    }

}
