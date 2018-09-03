package com.gupao.study.vip.Java7;

import javax.xml.transform.Source;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/**
 * <br>
 * Fork/Join计算
 * 递归的二分法
 * 并行计算
 * <br>Darian
 **/
public class Fork_Join {

    public static void main(String[] args) {

        // 并行：多核心参与
        // 并发：一同参与
        // JorkJoinPool 线程池：ForkJoinPool
        System.out.printf("当前   公用ForkJoin线程池  并行数：%d\n", ForkJoinPool.commonPool().getParallelism());
        System.out.printf("当前CPU 处理器数：%d\n", Runtime.getRuntime().availableProcessors());
        // 与    ThreadPoolExecutor  类似
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // invoke 调用的意思
        forkJoinPool.invoke(new RecursiveAction() {
            @Override
            protected void compute() {
                System.out.printf("[Thread: %s ]hello。。。。\n", Thread.currentThread().getName());
            }

        });
        forkJoinPool.shutdown();

    }
}
