package com.baidu.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2017/8/12.
 */
public class CollAsyMain {
    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        HashMap hashMap = new HashMap();

        // 装饰器
        Map map = Collections.synchronizedMap(hashMap);
        Vector vector;
        Collections.synchronizedList(new ArrayList<>());
    }
}
