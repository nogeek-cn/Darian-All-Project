package com.gupao.study.vip.before5;

/**
 * <br>
 * <br>Darian
 **/
public class ThreadMain {
    public static void main(String[] args) {

        // 子线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.printf("[Thread: %s ]hello\n", Thread.currentThread().getName());
            }
        }, "sub");

        thread.start();

        System.out.printf("[Thread: %s ]start......\n", Thread.currentThread().getName());
    }
}
