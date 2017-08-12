package com.baidu.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2017/8/12.
 */
public class ProfMain {
    // 并发量：1000 20000 200000 2000000 5000000
    private static int count = 5000000;
    public static void main(String[] args) throws InterruptedException {
        ThreadService threadService = new ThreadService();
        // hashtable 线程安全
        // 耗时： 1088 1962 3136 21122 46767
        Hashtable<String, String> hashtable = new Hashtable<>();
        // Collections.synchronizedXxx
        // 耗时： 2093 1365 2710 17597 42822
        Map<String, String> map = new HashMap<>();
        Map<String, String> synMap = Collections.synchronizedMap(map);
        //  ConcurrentHashMap
        // 耗时：  1559 1372 3024 19506 45186
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        CountDownLatch countHelper = new CountDownLatch(count);
        Long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            threadService.run(new Runnable() {
                @Override
                public void run() {
                    hashtable.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
                    countHelper.countDown();
                }
            });
        }
        countHelper.await();
        System.out.println(System.currentTimeMillis() - start);
    }
}
