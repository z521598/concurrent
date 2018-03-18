package com.baidu.interrupt;

import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/3/18.
 */

public class Cancel {
    private static final WeakHashMap<Integer, Thread> threadMap = new WeakHashMap<>();

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            final int finalI = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    threadMap.put(finalI, Thread.currentThread());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
//                        e.printStackTrace();/
                        System.out.println(finalI + " interrupted");
                    }

                    checkInterrupted();

                }


            });
            thread.start();
        }

        Thread.sleep(1000);
        Set<Map.Entry<Integer, Thread>> threadSet = threadMap.entrySet();
        for (Map.Entry<Integer, Thread> entry : threadSet) {
            System.out.println(entry.getKey());
            entry.getValue().interrupt();
        }
    }

    private static void checkInterrupted() {
        if (Thread.currentThread().isInterrupted()) {
            System.out.println("deal with interrupt");
            throw new RuntimeException("");
        }
    }


}
