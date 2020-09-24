package com.loiter.events;

import org.springframework.beans.BeansException;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;

/**
 * @Fun Description //TODO
 * @Date 2020/9/18 12:52 18
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
public class SpringBuiltInEventsListener implements ApplicationListener<SpringApplicationEvent>, ApplicationContextAware {

    ApplicationContext applicationContext;

    private void initPublisher(SpringApplicationEvent event) {
        if (event instanceof ApplicationReadyEvent) {
            this.applicationContext.getBean(Publisher.class).publishEvent();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(SpringApplicationEvent event) {
        Display.show("SpringApplicationEvent Received - " + event);
        this.initPublisher(event);
    }
}
