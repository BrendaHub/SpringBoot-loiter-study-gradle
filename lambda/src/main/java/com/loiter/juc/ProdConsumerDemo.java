package com.loiter.juc;

import java.sql.Time;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Aircondition {
    private int number = 0 ;
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public void decrement() {
        lock.lock();
        try{
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void increment() {
        lock.lock();
        try{
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ProdConsumerDemo {

    public static void main1(String[] args) {
        Aircondition aircondition = new Aircondition();
        new Thread(() -> {
            for(int i = 0 ; i < 11 ; i++) {
                try{
                    TimeUnit.SECONDS.sleep(1);
                    aircondition.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for(int i = 0 ; i < 11 ; i++) {
                try{
                    TimeUnit.SECONDS.sleep(1);
                    aircondition.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(22, () -> {
//            System.out.println("结果是" + atomicInteger.get());
//        });

        new Thread(() -> {
            for(int i = 0 ; i < 11 ; i++) {
                atomicInteger.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + "\t " + atomicInteger.get());

            } }, "A").start();

        new Thread(() -> {
            for(int i = 0 ; i < 11 ; i++) {
                atomicInteger.decrementAndGet();
                System.out.println(Thread.currentThread().getName() + "\t " + atomicInteger.get());

            }
        }, "B").start();

        TimeUnit.SECONDS.sleep(3);

            System.out.println("结果是" + atomicInteger.get());
    }
}
