package com.loiter;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Fun Description //TODO
 * @Date 2020/9/4 09:13 04
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/

// 函数式接口注解
//@FunctionalInterface
interface Hoo {
    // 没有参数
    public void sayHello();
    // 带参数接口
    public int add(int x , int y);

    default int hello(int x, int y ){
        return x + y;
    }
}

@FunctionalInterface
interface TestInterface {
    public void sub();
    @Override
    public boolean equals(Object var1);
    public default void defaultMethod() {
        System.out.println("defatlt Method");
    }
    public static  void staticMethod(){
        System.out.println("static Method");
    }
}
public class LambdaDemo {

    public static void main(String[] args) {
//        Foo lambdaFoo = (int x, int y) -> {
//            System.out.println ("Lambda表达式写法----->.main");
//            return x + y ;
//        }
        Map<String, Object> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++) {
            new Thread (() -> {
                map.put (UUID.randomUUID ().toString ().substring (0, 2), UUID.randomUUID ().toString ().substring (0,5));
                System.out.println (map);
            }, String.valueOf (i)).start ();
        }
    }
}
