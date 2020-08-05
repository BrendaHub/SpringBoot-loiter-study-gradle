package com.loiter.redis.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Fun Description //TODO
 * @Date 2020/8/5 10:10 05
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
public class Receiver {
    private final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private AtomicInteger counter = new AtomicInteger();

    public void receiveMessage(String message) {
        LOGGER.info("Received <" + message + " >");
        counter.incrementAndGet();// CAS  operation
    }

    public Integer getCount() {
        return counter.get();
    }
}
