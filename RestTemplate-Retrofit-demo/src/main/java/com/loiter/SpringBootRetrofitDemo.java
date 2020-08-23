package com.loiter;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 当前这个组件成熟度仍不是很强， 暂不进一步研究
 * 本文来源：http://8rr.co/RjGe
 *  https://juejin.im/post/6854573211426750472
 *
 */
@SpringBootApplication
@RetrofitScan("com.loiter.retrofit")
public class SpringBootRetrofitDemo {
    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(SpringBootRetrofitDemo.class, args);
        System.out.println(app);
    }
}
