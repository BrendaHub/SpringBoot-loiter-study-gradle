package com.loiter.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolDemo2 {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );

        try{

            for(int i = 0 ; i < 10 ; i++) {
                threadPoolExecutor.execute(() ->{
                    System.out.println(Thread.currentThread().getName() + "\t处理业务");
                });
            }
        }finally {
            threadPoolExecutor.shutdown();
        }
    }
}
