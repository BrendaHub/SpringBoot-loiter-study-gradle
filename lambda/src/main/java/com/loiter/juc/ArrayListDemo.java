package com.loiter.juc;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Fun Description //TODO
 * @Date 2020/9/4 20:41 04
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
public class ArrayListDemo {

    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        for(int i = 0 ; i < 1000 ; i ++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
