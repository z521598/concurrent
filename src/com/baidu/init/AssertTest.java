package com.baidu.init;

/**
 * Created by Administrator on 2018/3/17.
 */
// Page42
class Holder {
    private int n;

    public Holder(int n) {
        Thread.yield();
        this.n = n;
        Thread.yield();
    }


    public void testAssert() {
        // 猜测有编译器优化
        if (n != n) {
            throw new AssertionError(n);
        }
    }

    public int getN() {
        return n;
    }
}

public class AssertTest {
    public static Holder holder;

    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (finalI % 2 == 0) {
                        holder = new Holder(finalI);
                    } else {
                        if (holder != null) {
                            int n = holder.getN();
                            if (n == 0) {
                                System.out.println(finalI + " " + n);
                            }
                        }
                    }

                }
            }).start();
        }
    }
}
