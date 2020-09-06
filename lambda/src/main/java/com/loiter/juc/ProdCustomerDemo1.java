package com.loiter.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Aircondition1 {

    private  int number = 0;
    public int getNumber(){
        return this.number;
    }
    private  Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public  void increment() {
        lock.lock();

        try {
            while (number != 0 ){
                condition.await();
            }
            number++;
            System.out.println("number ++ is " + number);
            condition.signalAll();
         } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void deinerment() {
        lock.lock();
        try{
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println("number -- is " + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // 通过Synchronized 进行同步
    public synchronized void decrement() throws InterruptedException {
        // 判断
        while (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        this.notifyAll();
    }

    public synchronized void increment1() throws InterruptedException {
        while (number != 0) {
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        this.notifyAll();
    }

}

public class ProdCustomerDemo1 {
    public static void main(String[] args) {
        Aircondition1 aircondition1 = new Aircondition1();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println(aircondition1.getNumber());
        });
        new Thread(() -> {
            aircondition1.deinerment();
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "AA").start();
        for(int i = 0 ; i < 2 ; i++) {
            new Thread(() -> {
                aircondition1.increment();
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }, "BB"+i).start();
        }

    }
}
