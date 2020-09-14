package com.juc.executors;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @Fun Description //
 * @Date 2020/9/9 09:27 09
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 * 
 * 1） {@link FixedThreadPool } 和 {@link SingleThreadPool}：
 * 允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。
 * 2） {@link CachedThreadPool}：
 * 允许的创建线程数量为 Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM。
 **/
public class ExecutorsDemo {

    public static void defaultThreadFactory() {
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        threadFactory.newThread(new Thread(()->{
            System.out.println("通过defaultThreadFactory 创建的线程对象， 并执行完成。。");
        })).start();
    }

//    public static void aaa() {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//    }

    public static void main(String[] args) {
//        ExecutorsDemo.defaultThreadFactory();

//        System.out.println("product_experience".toUpperCase());
        long a = 23234234;
        int b = 234;
        int integer = Optional.ofNullable(b).orElse(0);
        System.out.println("i = " + integer);
        Double aDouble = Double.valueOf(integer);
        System.out.println(aDouble);
        System.out.println(a/b);
        System.out.println(Math.round(a/aDouble));

        Instant
    }

    /***
     * @Author chenhj(brenda)
     * @Description // 说明：如果是 JDK8 的应用，可以使用 Instant 代替 Date，LocalDateTime 代替 Calendar，
     * DateTimeFormatter 代替 SimpleDateFormat，官方给出的解释：simple beautiful strong immutable
     * thread-safe。
     * @Date 13:54 2020/9/11
     * @Param
     * @return
     * site: https://www.ant-loiter.com
     **/
    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };


}
