package com.baidu.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2017/8/11.
 */
public class HashMapMain {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        // HashMap 线程不安全Demo
        // 有时候会put进去null值
        Map<String, String> map = new HashMap<>();

        // 安全
        Map<String, String> synMap = Collections.synchronizedMap(map);
        // 安全
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        // 体现
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500; i++) {
                    concurrentHashMap.put(String.valueOf(i), String.valueOf(i));
                    try {
                        Thread.sleep(4);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                countDownLatch.countDown();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 500; i < 1000; i++) {
                    concurrentHashMap.put(String.valueOf(i), String.valueOf(i));
                }
                countDownLatch.countDown();
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1000; i < 1500; i++) {
                    concurrentHashMap.put(String.valueOf(i), String.valueOf(i));
                }
                countDownLatch.countDown();
            }
        });
        Long start = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        thread3.start();
        countDownLatch.await();
        System.out.println(System.currentTimeMillis() - start);
        for (int l = 0; l < 1500; l++) {
            //如果key和value不同，说明在两个线程put的过程中出现异常。
            if (!String.valueOf(l).equals(concurrentHashMap.get(String.valueOf(l)))) {
                System.err.println(String.valueOf(l) + ":" + concurrentHashMap.get(String.valueOf(l)));
            }
        }
    }
}
