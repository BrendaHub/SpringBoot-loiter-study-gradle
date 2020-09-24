package com.loiter.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Fun Description //TODO
 * @Date 2020/9/18 12:15 18
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
@Component
public class UserCreatedListener implements ApplicationListener<UserCreateEvent> {
    @Override
    public void onApplicationEvent(UserCreateEvent event) {
        Display.show(event.getName());
    }
}
