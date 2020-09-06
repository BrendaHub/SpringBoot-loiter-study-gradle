package com.loiter.juc;

import java.util.concurrent.*;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Callable  结束 ..... ";
            }
        });
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0 ; i < 7 ; i ++) {
            new Thread(futureTask, i+"Thread").start();
            TimeUnit.SECONDS.sleep(5);
            countDownLatch.countDown();
            String result = futureTask.get();
            System.out.println("futureTask is " + result);
            System.out.println("countDownLatch count is " + countDownLatch.getCount());
        }


        // timeout fh
        countDownLatch.await(5, TimeUnit.MICROSECONDS);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("ok");
        System.out.println("主线程执行结束");
    }
}
