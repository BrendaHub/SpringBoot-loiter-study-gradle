package com.loiter.redis;

import com.loiter.redis.receiver.Receiver;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;


/**
 * @Fun Description //TODO
 * @Date 2020/8/5 09:54 05
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 * 当要使用Spring Boot提供的redis客户端功能时，注入RedisTemplate的流程大致如下。
 * 1.pom中引入spring-boot-starter-data-redis，并配置application.properties。
 * 2.pom会根据spring-boot-starter-data-redis来引入spring-data-redis。
 * 3.spring-data-redis中包含RedisOperations类。
 * 4.启动Spring Boot，在refreshContext(context);中会初始化beanFactory，读取配置信息，初始化Spring容器，注入bean。因为@EnableAutoConfiguration开启的关系，会读取配置中EnableAutoConfiguration相关的类，并实例化注入Spring 容器。
 * 5.根据配置文件扫描到RedisAutoConfiguration。当RedisOperations存在时RedisAutoConfiguration才会被扫描。
 * 6.通过@EnableConfigurationProperties(RedisProperties.class)和@ConfigurationProperties(prefix = "spring.redis")，把application.properties中的对应属性进行绑定，并注入RedisProperties配置类。
 * 7.RedisAutoConfiguration中的@Import会引入LettuceConnectionConfiguration和JedisConnectionConfiguration
 * 8.LettuceConnectionConfiguration和JedisConnectionConfiguration被扫描，扫描到内部的@Bean，使用上一步中注入的RedisProperties bean作为参数来实例化LettuceConnectionFactory和JedisConnectionFactory，并以RedisConnectionFactory类注入Spring容器。
 * 8.扫描并注入RedisAutoConfiguration类内的@Bean，其中会使用RedisConnectionFactory bean作参数实例化RedisTemplate。
 * 9.将RedisTemplate实例注入。
 * 10.然后就能通过引用RedisTemplate来操作redis了。
 **/
@SpringBootApplication
public class MessageRedisApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageRedisApplication.class);

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter messageListenerAdapter){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(messageListenerAdapter, new PatternTopic("chat"));

        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    @Bean
    Receiver receiver() {
        return new Receiver();
    }

    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = SpringApplication.run(MessageRedisApplication.class, args);
        StringRedisTemplate stringRedisTemplate = ctx.getBean(StringRedisTemplate.class);
        Receiver receiver =  ctx.getBean(Receiver.class);

        while (receiver.getCount() <= 30 ){
            LOGGER.info("Count is  " + receiver.getCount());
            LOGGER.info("Sending message....");
            stringRedisTemplate.convertAndSend("chat", "Hello from Redis!" + receiver.getCount() + " times...");
            Thread.sleep(5000L);
        }
        System.exit(0);
    }


}
