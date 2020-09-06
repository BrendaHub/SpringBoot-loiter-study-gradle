package com.loiter.juc.readwriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyCache {

    private volatile Map<String, Object> map = new HashMap<>();

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        try{
            readWriteLock.writeLock().lock();// 上锁
            System.out.println (Thread.currentThread ().getName () + "\t正在写入" + key);
            TimeUnit.SECONDS.sleep(2);
            map.put(key, value);
            System.out.println (Thread.currentThread ().getName () + "\t写入完成--" + key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock(); // 下锁
        }
    }

    public Object get(String key) {
        Object result = null;
        try{
            readWriteLock.readLock().lock();
            System.out.println (Thread.currentThread ().getName () + "\t正在读出" + key);
            TimeUnit.SECONDS.sleep(3);
            result = map.get(key);
            System.out.println (Thread.currentThread ().getName () + "\t读出完成--" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }

        return result;
    }



}
