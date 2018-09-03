package com.gupao.study.vip.Java5;

import java.util.concurrent.*;

/**
 * <br>Callable是有返回值的操作，相当于Runable
 * <br>Darian
 **/
public class CalllableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //执行器服务，线程池（ThreadPoolExecutor）是它的一种实现
        // 线程池是线程的复用。
        ExecutorService executorService =
                Executors.newFixedThreadPool(1);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {

                return "[Thread: " + Thread.currentThread().getName() + "]hello,world";
            }
        });

        // join 挂了，get()没挂
        //  Waits if necessary for the computation to complete, and then retrieves its result.
        // 等待它知道成功。
        String value = future.get();

        System.out.println(value);

        // finally
        executorService.shutdown();
    }
}
