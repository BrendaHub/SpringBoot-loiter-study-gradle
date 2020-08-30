package com.event.eventpublish;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * {@link org.springframework.context.ApplicationEventPublisher }ApplicationEventPublisher 的二种获取方法示例
 * 第一种 {@link org.springframework.context.ApplicationEventPublisherAware} 实现这个接口回调获取
 * 第二种 {@link org.springframework.context.ApplicationContextAware} 通过这个方法也可以实现类例上面的方式发布event 事件
 *
 *
 */
public class CusEventPublisherDemo implements ApplicationContextAware, ApplicationEventPublisherAware, BeanPostProcessor {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    private void init() {

    }











    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {

    }
}
