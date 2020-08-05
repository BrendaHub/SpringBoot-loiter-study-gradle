package com.loiter.redis;
/**
 * @Fun Description //TODO
 * @Date 2020/8/5 16:51 05
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/

import com.loiter.redis.testimport.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private TestInfoA testInfoA;

    @Autowired
    private E e;

    @Autowired(required = false)
    private TestInfoB testInfoB;

    @Test
    void contextLoads() {
        System.out.println("OK");
        System.out.println("E is " + e);
        System.out.println("TestInfoB is " + testInfoB);
        TestConfig testConfig = new TestConfig();
        TestInfoTest testInfoAA = testConfig.testInfo(testInfoA);
        System.out.println((testInfoAA.getInfo() instanceof TestInfoB) ? "B" : "C");
        System.out.println(testInfoAA.getInfo().getClass().getName());
    }
}