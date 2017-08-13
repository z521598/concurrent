package com.baidu.callback;

import com.sun.javafx.tk.Toolkit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/8/13.
 */
public class Task2 {
    public void doSth(String sth,Object object){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" i hava do "+sth);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Class<?> clz = object.getClass();
                try {
                    Method method = clz.getMethod("onResult",String.class);
                    method.invoke(object,sth);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println("回调失败");
                }
            }
        }).start();
    }
}
