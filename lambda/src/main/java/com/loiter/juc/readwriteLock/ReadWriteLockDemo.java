package com.loiter.juc.readwriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for(int i = 0 ; i < 3 ; i++) {
            final int num = i ;
            new Thread(() -> {
                myCache.put(String.valueOf(num), String.valueOf(num));
            }, String.valueOf(i)+"write").start();
        }

        for(int i = 0 ; i < 3 ; i++) {
            final int num = i ;
            new Thread(() -> {
                Object o = myCache.get(String.valueOf(num));
                System.out.println(o.toString());
            }, String.valueOf(i)+"read").start();
        }
    }
}
