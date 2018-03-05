package com.baidu.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Administrator on 2018/3/5.
 */
public class Main {
    public static void main(String[] args) {
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

    }
}
