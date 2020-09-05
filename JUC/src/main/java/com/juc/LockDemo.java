package com.juc;

import java.util.concurrent.TimeUnit;

/**
 * https://github.com/Jacklinsir/Thread_jdk8-juc 示例， 继续研究
 */
class Phone {
    public static synchronized void sendEmail() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println(Thread.currentThread().getName() + "-----Phone sendEmail");

    }

    public synchronized void  sendSMS() {
        System.out.println(Thread.currentThread().getName() + "----Phone sendSMS");
    }

    public String sayHello() {
        return Thread.currentThread().getName() + "--- Hello, Thread。。。。";
    }
}

public class LockDemo {

    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone1 = new Phone();
        new Thread(()-> {
            try {
                Phone.sendEmail();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(()->{
            phone.sendSMS();
        }, "B").start();

        new Thread(()->{
            System.out.println(phone.sayHello());
        }, "C").start();
    }
}
