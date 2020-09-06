package com.loiter.juc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ReduceInt {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        int intValue = list.stream().reduce(0, (acc, e) -> acc + e).intValue();
        System.out.println(intValue);
        int sum = list.stream().mapToInt(e -> e).sum();
        System.out.println(sum);
        IntStream limit = list.stream().mapToInt(item -> item).limit(2);
        limit.sorted().forEach(System.out::println);

        List<User> userList = Arrays.asList(new User("A", 23.12f),
                new User("BB", 98.23f),
                new User("CC", 34.12f));
        List<User> uList = List.of(new User("A", 23.12f),
                new User("BB", 98.23f),
                new User("CC", 34.12f));

        userList.stream().forEach(System.out::println);
        uList.stream().forEach(System.out::println);

        double sum1 = userList.stream().mapToDouble(item -> item.getCores()).sum();
        System.out.println(sum1);

        /**
         * <U> reduce(U identity,
         *              BiFunction<U, ? super T, U> accumlator,
         *              BinaryOperator<U> combiner);
         *  identity: 不仅是reduction的初始值， 而且还是没有输入元素的情况下， 它还是默认的结果。
         *  accumulator函数接受一个局部结果和下一个元素， 产生一个新的局部结果。
         *  combiner 函数将两个局部结果组合起来生成一个新的局部结果。
         */
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        lists.add(list1);
        lists.add(list2);

        Integer reduce = lists.stream().reduce(0, (a, item) -> a + item.get(0), Integer::sum);
        System.out.println(reduce);

        Float reduce1 = uList.stream().reduce(0.0f,
                (s, item) -> s + item.getCores(),
                Float::sum);
        System.out.println(reduce1);

        Float reduce2 = uList.parallelStream().reduce(0.0f,
                (s, i) -> s + i.getCores(),
                Float::sum);
        System.out.println(reduce2);

        List<Float> floatList = Arrays.asList(23.3f, 2.23f);
        Float aFloat = floatList.parallelStream().reduce((x, y) -> x + y).get();
        System.out.println(aFloat);
        Float reduce3 = floatList.parallelStream().reduce(0.0f,
                (s, i) -> s + i,
                Float::sum);
        System.out.println(reduce3);
        double sum2 = floatList.parallelStream().mapToDouble(i -> i).sum();
        System.out.println(sum2);

    }

}

class User {
    private String name;
    private float cores;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", cores=" + cores +
                '}';
    }

    public User() {
    }

    public User(String name, float cores) {
        this.name = name;
        this.cores = cores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCores() {
        return cores;
    }

    public void setCores(float cores) {
        this.cores = cores;
    }
}
