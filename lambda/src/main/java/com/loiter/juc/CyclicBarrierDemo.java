package com.loiter.juc;

import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * CyclicBarrier
 * 是字面意思是可循环（cyclic),使用的屏障（Barrier）, 它要做的事情是。
 * 让一组线程到达一个屏障， 也可以理解是一个同步点， 时被阻塞
 * 直到最后一个线程到达屏障时， 屏障才会开门， 所有被屏障拦截的线程才会继续干活。
 * 线程进入屏障通过CyclicBarrier的await()方法。
 */
public class CyclicBarrierDemo {
    private static final int CYCLIC_BARRIER_NUM = 7;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(CYCLIC_BARRIER_NUM, () -> {
            System.out.println("GO，。。。。");
            System.out.println("GO，。。。。");
        });
        for(int i = 0 ; i < CYCLIC_BARRIER_NUM ; i ++) {
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName() + " 到位 ");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }

    }
}
