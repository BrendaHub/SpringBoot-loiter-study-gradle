package com.nettty.protobuf;

import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        System.out.println("Inside: "+ Thread.currentThread().getName());
//        System.out.println("Creating ExecutorService");
//
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        System.out.println("Creating a Runnable");
//        Runnable runnable = () -> {
//            System.out.println("sub Inside: " + Thread.currentThread().getName());
//        };
//        System.out.println("Submitting the task specified by the runnable to the executorservice ");
//        executorService.submit(runnable);
//
//        if (executorService.isTerminated()) {
//            executorService.shutdown();
//        }
//
//        TimeUnit.SECONDS.sleep(20);
//
//        for(int i = 1 ; i < 3; i ++) {
//            TimeUnit.SECONDS.sleep(2);
//            System.out.println(executorService.isTerminated());
//            System.out.println(executorService.isShutdown());
//            ThreadLocal<String> threadLocal = new ThreadLocal<>() {
//
//            };
//            executorService.submit(runnable);
//        }
//
//        executorService.shutdownNow();

//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
//        ScheduledFuture<User> executed = scheduledExecutorService.schedule(new Callable<User>() {
//            @Override
//            public User call() throws Exception {
//                System.out.println("executed");
//                return new User("brenda");
//            }
//        }, 20, TimeUnit.SECONDS);
//        System.out.println(executed.get().getUserName(", HAHA"));
//
//        Runnable runnable = () -> {
//            System.out.println("OK");
//        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            ThreadLocal<String> threadLocal = new ThreadLocal<>();
            threadLocal.set("hello");

            System.out.println("runnable method"+ threadLocal.get());
        });

        Thread thread = new Thread(() -> {
            System.out.println("run is over");
        });

        executorService.submit(thread);

        // 这个是执行，没有回调, Future 是个NUll
        Future<?> submit = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(" asynchronous task ");

            }
        });
        System.out.println("====");
        System.out.println(">>>>" + submit.get());

        Future<Object> submit1 = executorService.submit(new Callable<Object>() {

            @Override
            public Object call() throws Exception {
                System.out.println(" Asynchronous callable ");
                return "Callable Result ";
            }
        });
        System.out.println("Future.get() = " + submit1.get());

        executorService.shutdown();
        System.out.println(executorService.isTerminated());
        System.out.println(executorService.isShutdown());



    }

    static class User{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public User(String name) {
            this.name = name;
        }

        public String getUserName(String prefix) {
            return this.name + prefix;
        }
    }
}
