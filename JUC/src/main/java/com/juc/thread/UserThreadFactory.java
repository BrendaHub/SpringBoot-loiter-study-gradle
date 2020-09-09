package com.juc.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Fun Description // 标准的创建线程工厂的例子
 * @Date 2020/9/9 08:56 09
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
public class UserThreadFactory implements ThreadFactory {
    private String threadNameprefix ;

    private AtomicInteger nextId = new AtomicInteger();

    UserThreadFactory(String whatFeatureOfGroup) {
        this.threadNameprefix = "from UserThreadFactory.s " +  whatFeatureOfGroup + "-Worker-";
    }

    @Override
    public Thread newThread(Runnable r) {
        String name = threadNameprefix + nextId.getAndIncrement();
        Thread thread = new Thread(null, r, name, 0, false);
        System.out.printf("thread name is {%s}", thread.getName());
        System.out.println("---");
        return thread;
    }

}
