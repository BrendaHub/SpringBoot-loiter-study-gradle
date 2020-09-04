package com.loiter.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Fun Description //TODO
 * @Date 2020/9/4 20:44 04
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
public class BlockingQueueDemo {

    public static void main(String[] args) {
        //        List list = new ArrayList();

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        //第一组
        System.out.println (blockingQueue.add ("a"));
        System.out.println (blockingQueue.add ("b"));
        System.out.println (blockingQueue.add ("c"));
        //Exception in thread "main" java.lang.IllegalStateException: Queue full
//         System.out.println (blockingQueue.add ("d"));
        System.out.println (blockingQueue.element ());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.element());

        //System.out.println(blockingQueue.add("x"));
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//    第二组
//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("b"));
//        System.out.println(blockingQueue.offer("c"));
//        System.out.println(blockingQueue.offer("x"));
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//    第三组
//         blockingQueue.put("a");
//         blockingQueue.put("b");
//         blockingQueue.put("c");
//         //blockingQueue.put("x");
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());

//    第四组
        /*System.out.println (blockingQueue.offer ("a"));
        System.out.println (blockingQueue.offer ("b"));
        System.out.println (blockingQueue.offer ("c"));
        System.out.println (blockingQueue.offer ("a", 3L, TimeUnit.SECONDS));*/
    }
}
