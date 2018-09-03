package com.gupao.study.vip.before5;

/**
 * <br>
 * <br>Darian
 **/
public class CompletedRunableMain {
    public static void main(String[] args) throws InterruptedException {
        CompletedRunable completedRunable = new CompletedRunable();
        Thread thread = new Thread(completedRunable, "sub");
        thread.start();
        // 等这个线程去死,就是串行操作了。带 synchronized 关键字
       thread.join();

        System.out.printf("[Thread: %s ]start......\n", Thread.currentThread().getName());
        System.out.printf("runable is completed: %s \n",
                completedRunable.isCompleted());
    }

    private static class CompletedRunable implements Runnable {
        private volatile boolean completed = false;

        @Override
        public void run() {
            System.out.printf("[Thread: %s ]hello\n", Thread.currentThread().getName());
            completed = true;
        }

        public boolean isCompleted() {
            return completed;
        }
    }
}
