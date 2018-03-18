package com.baidu.synchronize;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/17.
 */
class LList {
    List list = new ArrayList<>();

    public int size() {
        System.out.println("size want to get lock");

        synchronized (list) {
            System.out.println("size want to get lock");
            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return list.size();
        }
    }

    public boolean add(Object o) {
        System.out.println("add want to get lock");
        synchronized (list) {
            System.out.println("add geted lock");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return list.add(o);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LList lList = new LList();
        Thread threadAdd = new Thread(new Runnable() {
            @Override
            public void run() {
                lList.add(new Object());
            }
        });
        Thread threadSize = new Thread(new Runnable() {
            @Override
            public void run() {
                lList.size();
            }
        });
        Thread threadAddSize = new Thread(new Runnable() {
            @Override
            public void run() {
                lList.add(new Object());
                lList.size();
            }
        });
//        threadAdd.start();
//        threadSize.start();
        threadAddSize.start();
    }

}
