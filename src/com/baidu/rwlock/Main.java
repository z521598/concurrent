package com.baidu.rwlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Administrator on 2017/8/12.
 */
public class Main {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        boolean flag = reentrantLock.tryLock();
        try{

        }finally {
            if(flag){
                reentrantLock.unlock();
            }
        }

        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        Lock wlock = reentrantReadWriteLock.writeLock();
        Lock rlock = reentrantReadWriteLock.readLock();


    }
}
