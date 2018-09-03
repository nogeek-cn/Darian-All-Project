package com.gupao.study.vip.Java7;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.LongAdder;

/**
 * <br>
 * 1-10累加
 * <br>Darian
 **/
public class ForkJoinDemo2 {

    public static void main(String[] args) {
        // 并行：多核心参与
        // 并发：一同参与
        // JorkJoinPool 线程池：ForkJoinPool
        System.out.printf("当前   公用ForkJoin线程池  并行数：%d\n", ForkJoinPool.commonPool().getParallelism());
        System.out.printf("当前CPU 处理器数：%d\n", Runtime.getRuntime().availableProcessors());
        // 与    ThreadPoolExecutor  类似
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // 累加对象，Java 8 中
        LongAdder longAdder = new LongAdder();
        // RecursiveAction 递归操作
        Addtask addtask = new Addtask(nums, longAdder);

        forkJoinPool.invoke(addtask);

        forkJoinPool.shutdown();

        System.out.println(nums + "累加的结果：" + longAdder);
    }

    private static class Addtask extends RecursiveAction {
        private final List<Integer> nums;

        private final LongAdder longAdder;

        public Addtask(List<Integer> nums, LongAdder longAdder) {
            this.nums = nums;
            this.longAdder = longAdder;
        }

        @Override
        protected void compute() {
            int size = nums.size();

            if (size > 1) {
                // 二分法
                int parts = size / 2;
                // 上半部
                List<Integer> leftPart = nums.subList(0, parts);
                Addtask leftTask = new Addtask(leftPart, longAdder);
                // 下半部
                List<Integer> rightPart = nums.subList(parts, size);
                Addtask rightTask = new Addtask(rightPart, longAdder);
                invokeAll(leftTask, rightTask);


            } else {// 当前的元素只有一个
                if (size == 0) {// 保护
                    return;
                }
                Integer value = nums.get(0);
                // 累加
                longAdder.add(value.longValue());
            }

        }

    }
}
