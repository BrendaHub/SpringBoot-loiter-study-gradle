package com.loiter.redis.testimport;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Fun Description //TODO
 * @Date 2020/8/5 18:33 05
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
@Component
//@Order(value = 9)
@Primary
public class G implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作  30 30 30 30 30 <<<<<<<<<<<<<");
    }
}
