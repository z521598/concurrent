package com.baidu.collection;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/8/11.
 */
public class ThreadService {
    private ExecutorService executor = Executors.newFixedThreadPool(1000);
    public void run(Runnable runnable){
        executor.execute(runnable);
    }
    public void close(){
        executor.shutdownNow();
    }

}
