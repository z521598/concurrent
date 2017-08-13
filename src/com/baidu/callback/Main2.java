package com.baidu.callback;

/**
 * Created by Administrator on 2017/8/13.
 */
public class Main2 {
    public void test(String sth){
        Task2 task2 = new Task2();
        task2.doSth("paly",this);
    }
    public void onResult(String sth){
        System.out.println("ok");
    }
    public static void main(String[] args) {
        Main2 main2 = new Main2();
        main2.test("213");
    }
}
