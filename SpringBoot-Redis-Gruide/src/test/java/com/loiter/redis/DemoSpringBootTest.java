//package com.loiter.redis;
//
//import jdk.nashorn.internal.ir.annotations.Ignore;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.DefaultTypedTuple;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ZSetOperations;
//import org.springframework.util.Assert;
//
//import java.util.*;
//
///**
// * @Fun Description //TODO
// * @Date 2020/8/11 17:00 11
// * @Author chenhj(brenda)
// * site: https://www.ant-loiter.com
// **/
//
//public class DemoSpringBootTest extends  DemoApplicationTests{
//
//    @Autowired(required = false)
//    private StringRedisTemplate redisTemplate;
//
//    @Test
//    @Ignore
//    public void test() {
//        System.out.println("Hello Test");
//        System.out.println("redisTemplate = " + redisTemplate);
//    }
//
//    @Test
//    public void test1() {
//        // 向集合中插入元素， 并设计分数
//        redisTemplate.opsForZSet().add("ranking-list", "p1", 2.1);
//
//        // 向集合中插入多个元素
//        DefaultTypedTuple<String> tuple1 = new DefaultTypedTuple<>("p2", 1.1);
//        DefaultTypedTuple<String> tuple2 = new DefaultTypedTuple<>("p3", 3.1);
//        DefaultTypedTuple<String> tuple3 = new DefaultTypedTuple<>("p4", 23.1);
//        DefaultTypedTuple<String> tuple4 = new DefaultTypedTuple<>("p5", 39.1);
//        DefaultTypedTuple<String> tuple5 = new DefaultTypedTuple<>("p6", 123.1);
//        DefaultTypedTuple<String> tuple6 = new DefaultTypedTuple<>("p7", 7.1);
//        redisTemplate.opsForZSet().add("ranking-list", new HashSet<>(Arrays.asList(tuple1, tuple2, tuple3, tuple4, tuple5, tuple6)));
//
//        printZSet("ranking-list");
//
//
//    }
//
//    @Test
//    public void testHash() {
//        //初始数据:
//        //template.opsForHash().put("redisHash","name","tom");
//        //template.opsForHash().put("redisHash","age",26);
//        //template.opsForHash().put("redisHash","class","6");
//        // 通过hashMap添加hash
//        Map<String,Object> testMap = new HashMap<String, Object>();
//        testMap.put("name","jack");
//        testMap.put("age", new Integer(27));
//        testMap.put("class","1");
//        redisTemplate.opsForHash().putAll("redisHash1",testMap);
//
//    }
//
//    @Test
//    public void testSet() {
//        String[] strarrays = new String[]{"python", "rust"};
//        Long result = redisTemplate.opsForSet().add("setTest", strarrays);
//        System.out.println(" result is " + result);
//    }
//
//    @Test
//    public void test2() {
//        printZSet("ranking-list");
//        // 从集合中删除指定的元素
//        Long result = redisTemplate.opsForZSet().remove("ranking-list", "p1");
//        Assert.isTrue(result == 1, "成功");
//        System.out.println("result is " + result);
//    }
//
//    @Test
//    public void test3() {
//        // 为指定的元素加分
//        Double score = redisTemplate.opsForZSet().incrementScore("ranking-list", "p2", 200);
//        System.out.println("score is " + score);
//        printZSet("ranking-list");
//    }
//
//    @Test
//    public void test4() {
//        // 返回指定成员的排名（从小到大）,, 默认是升序， 从0开始排
//        Long rank = redisTemplate.opsForZSet().rank("ranking-list", "p3");
//        // 从大到小
//        Long reverRank = redisTemplate.opsForZSet().reverseRank("ranking-list", "p3");
//        System.out.println("rank is " + rank);
//        System.out.println("reversRank is " + reverRank);
//    }
//
//    @Test
//    public void test5() {
//        // 返回集合内元素的排号名， 及分数（从小到大）黑夜升序
//        Set<ZSetOperations.TypedTuple<String >> tuples = redisTemplate.opsForZSet().rangeWithScores("ranking-list", 0, -1);
//        for (ZSetOperations.TypedTuple<String> tuple : tuples) {
//            System.out.println(tuple.getValue() + "  :  " + tuple.getScore());
//        }
//    }
//
//    @Test
//    public void test6() {
//        // 返回集合内指定分数范围内的排名（从小到大）
//        Set<String> ranking = redisTemplate.opsForZSet().rangeByScore("ranking-list", 0, 5);
//        System.out.println(ranking);
//        // 带偏移量的个数， 下例意为从第二个开妈， 要后三个
//        Set<String> randking2 = redisTemplate.opsForZSet().rangeByScore("ranking-list", 0, 5, 1, 3);
//        System.out.println(randking2);
//    }
//
//    @Test
//    public void test7() {
//        // 返回集合中指定分数范围的成员个数
//        Long count = redisTemplate.opsForZSet().count("ranking-list", 200, 300);
//        System.out.println(count);
//        // 返回集中中的所有成员个数
//        Long size = redisTemplate.opsForZSet().size("ranking-list");
//        System.out.println(size);
//    }
//
//    @Test
//    public void test8() {
//        // 获取指定元素的分数
//        Double score = redisTemplate.opsForZSet().score("ranking-list", "p2");
//        System.out.println(score);
//    }
//
//    @Test
//    public void test9() {
//        // 删除指定索引范围的元素
//        printZSet("ranking-list");
//        redisTemplate.opsForZSet().removeRange("ranking-list", 0, 4);
//        printZSet("ranking-list");
//    }
//
//    @Test
//    public void test10() {
//        // 删除指定分数范围的元素
//        printZSet("ranking-list");
//        redisTemplate.opsForZSet().removeRangeByScore(
//                "ranking-list",
//                2,
//                5
//        );
//        printZSet("ranking-list");
//    }
//
//    private void printZSet(String key) {
//        //按照排名先后(从小到大)打印指定区间内的元素, -1为打印全部
//        Set<String> range = redisTemplate.opsForZSet().range(key, 0, -1);
//        //reverseRange 从大到小
//        System.out.println(range);
//    }
//}
