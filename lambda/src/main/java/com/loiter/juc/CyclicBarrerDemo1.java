package com.loiter.juc;


import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrerDemo1 {

    private static Map<String, Long> result = new ConcurrentHashMap<>();

    private static final int CYCLIC_BARRER_NUM = 5;


    public static void doResult() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(CYCLIC_BARRER_NUM, () -> {
            // 将所有结果sum
            System.out.println("-----------------");
            result.forEach((k,v) -> {
                System.out.println("k is " + k + ", v is " + v);
            });
            long sum = result.values().stream().mapToLong(item -> item).sum();
            System.out.println("sum is " + sum);
        });

        for( int i = 0 ; i < CYCLIC_BARRER_NUM + 2 ; i ++) {
            new Thread(() -> {
                result.put("AA" + new Random().nextLong(), 1L);
                result.forEach((k,v) -> {
                    System.out.println("k is " + k + ", v is " + v);
                });
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

    public static void main(String[] args) {
        CyclicBarrerDemo1.doResult();
    }
}
