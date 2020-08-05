package com.loiter.redis.testimport;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Fun Description //TODO
 * @Date 2020/8/5 16:34 05
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/

@Configuration
@Import({B.class, C.class})
public class TestConfig {

    @Bean
    public TestInfoTest testInfo(TestInfoA param) {
        TestInfoTest info = new TestInfoTest();
        info.setInfo(param);
        return info;
    }
}
