package cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Fun Description //TODO
 * @Date 2020/8/24 15:59 24
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
public class MemoryRecycleTest {

    public void testMemoryRecycle() {
        List<String> list = new ArrayList<>();
        int count = 512;
        new Thread(()->{
            try{
                for(int i = 1 ; i <= 10; i++) {
                    System.out.println(String.format("第%s次生产%s大小的对象", i, count));
//                    addObject(list, count);

                    Thread.sleep(i * 10000);
                }
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            for(;;) {
                if (list.size() >= count) {
                    System.out.println("清理list... 回收JVM内存...");
                    list.clear();
                    System.gc();
//                    printJvmMemoryInfo();
                }
            }
        }).start();

//        Thread.currentThread().join();
    }
}
