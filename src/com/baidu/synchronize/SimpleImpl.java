package com.baidu.synchronize;

/**
 * Created by Administrator on 2018/3/5.
 */
public class SimpleImpl implements SimpleInterface {
    @Override
    public void test(Synch synch) {
        System.out.println("??");
        synch.remove(this);
    }
}
