package com.baidu.synchronize;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2018/3/5.
 */
public class Synch {

    private Set<SimpleInterface> set = new HashSet<>();

    {
        set.add(new SimpleImpl());
        set.add(new SimpleImpl());
        set.add(new SimpleImpl());
        set.add(new SimpleImpl());
        set.add(new SimpleImpl());

    }

    public void test1() {
        synchronized (set) {
            for (SimpleInterface simpleInterface : set) {
                simpleInterface.test(this);
            }
        }
    }

    public void remove(SimpleInterface element) {
        synchronized (set) {
            set.remove(element);
        }
    }
    // 容器抛出的异常，此处为非法操作，并发修改
    // Exception in thread "main" java.util.ConcurrentModificationException
    public static void main(String[] args) {
        Synch synch = new Synch();
        synch.test1();
    }
}
