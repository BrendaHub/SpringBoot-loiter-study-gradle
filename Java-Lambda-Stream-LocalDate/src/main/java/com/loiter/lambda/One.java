package com.loiter.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class One {
    public static void main1(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");
        for (String key: map.keySet()) {
            System.out.println("key = " + key + ", value = " + map.get(key));
        }
        map.forEach((k, v) -> {
            System.out.println("key = " + k + ", value = " + v);
        });
        // 这种遍历只是遍历了key的内容
        map.forEach(System.out::printf);

        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("bb");
        list.add("ccc");
        list.add("dddd");
        list.forEach( v ->
        {
            System.out.println("vlu is " + v);
        });
        list.forEach(v -> System.out.println("vlu is is " + v));
        list.forEach(System.out::println);

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("普通方式创建");
            }
        };
        new Thread(r1).start();

        Runnable r2 = () -> System.out.println("lambda方式创建");
        new Thread(r2).start();


    }
}
