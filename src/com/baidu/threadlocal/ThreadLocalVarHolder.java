package com.baidu.threadlocal;

/**
 * Created by Administrator on 2017/7/30.
 */
public class ThreadLocalVarHolder {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "00";
        }
    };

    public void setStr(String str) {
        threadLocal.set(str);
    }

    public String getStr() {
        return threadLocal.get();
    }
    public void rise(){
        threadLocal.set(threadLocal.get()+"9");
    }
}
