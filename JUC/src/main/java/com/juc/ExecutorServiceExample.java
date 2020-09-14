package com.juc;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Set<Callable<String>> callables = new HashSet<>();
        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task 1";
            }
        });
        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task 2";
            }
        });
        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task 3";
            }
        });
        AtomicInteger index = new AtomicInteger();
        while (index.get() < 4) {

//            String s = executorService.invokeAny(callables);
            List<Future<String>> s = executorService.invokeAll(callables);
            s.stream().forEach(item ->{
                try {
                    System.out.println(item.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
            index.incrementAndGet();
            System.out.println(index.get());
            TimeUnit.SECONDS.sleep(5);
        }
//        executorService.shutdown();
//
    }
}
