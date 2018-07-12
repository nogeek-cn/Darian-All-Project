package com.gupao.study.vip;


import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class TestDistributedLock {
    public static void main(String[] args) throws IOException {
        final CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    countDownLatch.await();
                    DistributedLock distributedLock = new DistributedLock();
                    // 获得锁
                    distributedLock.lock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Thread-"+i).start();
            countDownLatch.countDown();
        }
        System.in.read();
    }
}
