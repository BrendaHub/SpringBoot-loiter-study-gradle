package com.loiter.lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Two_Stream {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("张三", "李四", "王五", "xuwujing");

        System.out.println("filter before list is " + list);
        List<String> result = new ArrayList<>();
        for (String str : list) {
            if (!"李四".equals(str)) {
                result.add(str);
            }
        }
        System.out.println("filter after is " + result);
        List<String> _result = list.parallelStream().filter(item -> !item.equals("李四"))
                .collect(Collectors.toList());
        _result.forEach(System.out::println);
        System.out.println(_result);

        try{
            // 将一系列的字符串转换在一个Steam
            Stream<User> userStream = Stream.of(new User("a", 23), new User("b",32));
//            userStream.collect(Collectors.toList());
            // 上面的操作已经是action类的操作， 操作完后userStream就会被关闭掉
            userStream.forEach(System.out::println);
            Stream<String> stream2 = Stream.of("a","b","c","d");
            // 转换成Array
//            String[] strArray1 = stream2.toArray(String[]::new);
            Object[] objArray = stream2.toArray();

        }catch (Exception e) {
            e.printStackTrace();
        }

        List<String> list3 = Arrays.asList("zhangSan", "liSi", "wangWu");
        System.out.println("list3 = " + list3);
        List<String> collect = list3.parallelStream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);
        List<String> list4 = Arrays.asList("1", "2", "3");
        List<Integer> collect1 = list4.parallelStream().map(Integer::valueOf).collect(Collectors.toList());
        System.out.println(collect1);
        List<Integer> list5 = Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,4});
        List<Double> collect2 = list5.parallelStream().map(Math::sqrt).collect(Collectors.toList());
        System.out.println(collect2);
        List<Integer> collect3 = list5.parallelStream().map(item -> item * item).collect(Collectors.toList());
        System.out.println(collect3);
        List<String> _6list = Arrays.asList("张三", "李四", "王五", "xuwujing");
        String s = _6list.parallelStream().filter(item -> item.equals("李四")).findAny().orElse("not found item");
        System.out.println("s =  " + s);
        String s1 = _6list.parallelStream().filter(item -> item.equals("toolbarButtonGraphics"))
                .findAny().orElse("not found items");
        System.out.println("s1 is " + s1);
        // 通过MaptoInt计算
        List<User> _7list = new ArrayList<>();
        _7list.add(new User("张三", 23));
        _7list.add(new User("张四", 12));
        _7list.add(new User("张三", 54));
        _7list.add(new User("张六", 32));
        // 计算名字为张三的年龄总和
        double sum = _7list.parallelStream().filter(item -> item.getName().equals("张三"))
                .mapToDouble(item -> item.getAge()).sum();
        System.out.println("张三年龄总和为： " + sum);

        double v = _7list.parallelStream().filter(item -> "张三".equals(item.getName()))
                .mapToDouble(item -> item.getAge())
                .average()
                .orElse(0.0);
        System.out.println(v);

        // flatMap方法用于映射每个元素到对应的结果 一对多
        String worlds = "The way of the future";
        List<String> words = new ArrayList<>();
        words.add(worlds);
        List<String> collect4 = words.parallelStream().flatMap(item -> Stream.of(item.split(" ")))
                .filter(item -> item.length() > 0)
                .collect(Collectors.toList());
        System.out.println(collect4);

        String[] strs = new String[]{"python", "JavaScript", "activeScript", "Java", "python", "JavaScript"};
        Optional<String> reduce = Stream.of(strs).map(String::toUpperCase)
                .reduce((a, b) -> a + b);
        System.out.println(reduce.isPresent());
        System.out.println(reduce.get());

        String aa = "Spring is constantly evolving and always innovating while being consistent where it matters: delivering a reliable framework to help you build maintainable software, faster. In the last few years, the Spring contributors have worked hard to bring the predictable Spring experience to microservices, serverless, streams, reactive, batch, data, and new languages like Kotlin. Over the coming year, you’ll see many more examples of this, including some cool new features that we’re just dying to share with you.";
        List<String> collect5 = Stream.of(aa).flatMap(item -> Stream.of(item.split(" ")))
                .filter(item -> item.length() > 3)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(collect5);
        System.out.println(collect5.size());

        // limit 方法用于获取指定数量的流
        new Random().ints(1000).limit(3).map(item -> Math.round(Math.floorDiv(item, 22)))
                .forEach(System.out::println);

        new Random().ints(0, 10).limit(30).forEach(System.out::println);

        // skip khi


    }
}
