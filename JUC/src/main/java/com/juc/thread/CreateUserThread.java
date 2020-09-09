package com.juc.thread;

/**
 * @Fun Description // 标准创建自定义的线程工厂的例子， 根据java开发规范来创建的，
 * @Date 2020/9/9 09:11 09
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
public class CreateUserThread {

    public static void main(String[] args) {
        UserThreadFactory userThreadFactory = new UserThreadFactory("beijing-001");

        Thread thread = userThreadFactory.newThread(new Thread(() -> {
            System.out.println("自定义的线程运行......");
        }));
        thread.start();

    }


}
