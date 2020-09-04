package com.loiter.juc;

import com.loiter.lambdaMap;

import java.time.LocalDateTime;
import java.util.concurrent.*;

/**
 * @Fun Description //TODO
 * @Date 2020/9/4 20:51 04
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
public class CallableDemo {

    public static void main1(String[] args) {
        FutureTask<String> stringFutureTask = new FutureTask<>(new Callable<String>() {

            @Override
            public String call() throws Exception {
                return "Callable 线程. ......";
            }
        });

        new Thread(stringFutureTask, "A").start();
        String s = null;
        try {
            System.out.println(stringFutureTask.isCancelled());
            System.out.println(stringFutureTask.isDone());
            s = stringFutureTask.isDone()?stringFutureTask.get(30, TimeUnit.SECONDS):"没有结束";
            System.out.println("s -- first is " + s );
            s = stringFutureTask.isDone()?stringFutureTask.get(10, TimeUnit.SECONDS):"noCompleted";
            System.out.println("s --> " + s);
            s = stringFutureTask.get();
            System.out.println("s --- end --" + s );
            System.out.println("is Done is " + stringFutureTask.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("s = " + s);
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Foo foo = new Foo();
        FutureTask<Foo> task = new FutureTask<>(new Callable<Foo>() {
            @Override
            public Foo call() throws Exception {
                foo.setAddress("Beijin");
                foo.setLocalDateTime(LocalDateTime.now());
                return foo;
            }
        });

        new Thread(task, "AA").start();

        Foo foo1 = task.get();
        System.out.println(foo1);

    }
}
