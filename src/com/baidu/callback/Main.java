package com.baidu.callback;

/**
 * Created by Administrator on 2017/8/13.
 */
public class Main implements Result{
    public  void main() throws InterruptedException {
        Task task = new Task();
        task.doSth("eat",this);

    }

    @Override
    public void onResult(String result) {
        System.out.println("have done , i want to do sth others");
    }
}
