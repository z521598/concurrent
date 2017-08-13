package com.baidu.callback;

import com.sun.javafx.tk.Toolkit;

/**
 * Created by Administrator on 2017/8/13.
 */
public class Task {
    public void doSth(final String sth,final Result result){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" i hava do "+sth);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                result.onResult(sth);
            }
        }).start();
    }
}
