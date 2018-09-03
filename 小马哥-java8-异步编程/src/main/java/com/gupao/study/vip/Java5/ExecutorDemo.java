package com.gupao.study.vip.Java5;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <br>
 * <br>Darian
 **/
public class ExecutorDemo {

    public static void main(String[] args) {

        // 执行器，线程池（ThreadProolExecutor）是它的一种实现
        Executor executor = Executors.newFixedThreadPool(1);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.printf("[Thread: %s ]hello.....\n", Thread.currentThread().getName());
            }
        });

        // 合理的关闭线程池是非常重要的
        if(executor instanceof ExecutorService){
            ExecutorService executorService = ExecutorService.class.cast(executor);
            executorService.shutdown();
        }

        // Java 5 开始实施 AutoCloseable, I/O ， JDBC
        // 自动关闭
    }
}
