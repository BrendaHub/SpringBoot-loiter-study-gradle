package com.loiter.events;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Fun Description //TODO
 * @Date 2020/9/18 11:48 18
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
@Component
public class AsyncListener {

    @EventListener
    @Async  // 异常
    void handleAsyncEvent(String event) {
        System.out.println(String.format("Async event recevied: %s", event));
    }
}
