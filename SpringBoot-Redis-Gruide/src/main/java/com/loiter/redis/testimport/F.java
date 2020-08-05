package com.loiter.redis.testimport;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Fun Description //TODO
 * @Date 2020/8/5 18:30 05
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
@Component
//@Order(value = 10)
public class F implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作 20 20 20 20 20 <<<<<<<<<<<<<");
    }
}
