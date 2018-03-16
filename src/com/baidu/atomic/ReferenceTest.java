package com.baidu.atomic;

import java.lang.ref.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2018/3/16.
 */
public class ReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        // 强引用
        Person person = new Person("Final",100);

        // 软引用
        Reference<Person> softReference = new SoftReference(new Person("Soft",90));
        System.gc();
        // 弱引用
        Reference<Person>  weakReference = new WeakReference(new Person("Weak",80));

        System.gc();

        Thread.sleep(1000);

        ReferenceQueue<Person> referenceQueue = new ReferenceQueue<>();;

        Reference<Person> phantomReference = new PhantomReference<>(new Person("Phantom",70),referenceQueue);
        System.out.println(phantomReference.get()+"==");
        System.gc();
        System.out.println(referenceQueue.remove(2000));
        System.out.println(referenceQueue.poll());


    }
}
