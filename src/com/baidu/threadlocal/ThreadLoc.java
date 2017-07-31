package com.baidu.threadlocal;

/**
 * Created by Administrator on 2017/7/30.
 */
public class ThreadLoc extends Thread {

    private static ThreadLocalVarHolder stringThreadLocal = new ThreadLocalVarHolder();

    public ThreadLoc(String tlStr) {
        stringThreadLocal.setStr(tlStr);
    }

    @Override
    public void run() {
        System.out.println(stringThreadLocal.getStr());
        stringThreadLocal.rise();
        System.out.println(stringThreadLocal.getStr());
        Thread.interrupted();
        stringThreadLocal.rise();
        System.out.println(stringThreadLocal.getStr());

    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            new ThreadLoc(String.valueOf(i)).start();
        }
    }
}
