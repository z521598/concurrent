package com.baidu.threadPoolExecutor;

import java.util.Date;
import java.util.concurrent.*;

/**
 * Crea ted by Administrator on 2018/3/18.
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(6);
        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date());
            }
        }, 1000L, 2000L, TimeUnit.MILLISECONDS);

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
