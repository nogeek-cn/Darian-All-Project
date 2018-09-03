package com.gupao.study.vip.Java8;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * <br>
 * <br>Darian
 *
 * @see CompletionStage
 * @see CompletableFuture
 **/
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {

        /**
         * 1. 完成操作（可以被其他线程去做）
         **/
//        CompletableFuture<String> completableFuture = new CompletableFuture<String>();

//        completableFuture.complete("Hello, World");
//
//        String value = completableFuture.get();
//
//        System.out.println(value);

        /**
         * 2. 异步执行，阻塞操作
         **/

//        CompletableFuture asyncCompletableFuture = CompletableFuture.runAsync(() -> {
//            System.out.println("hello, world");
//        });
//
//        // 仍然是阻塞操作
//        asyncCompletableFuture.get();
//
//        System.out.println("Starting......");

        /**
         * 真正的异步
         **/
        // 非 lambda 写法
//        CompletableFuture asyncCompletableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
//
//            @Override
//            public String get() {
//                return "hello.World";
//            }
//        });

        // lambda 写法
//        CompletableFuture<String> asynoCompletableFuture = CompletableFuture.supplyAsync(() -> {
//            // 获取数据操作，假设来自于数据库
//            return String.format("[Thread: %s ]hello。。。。\n",
//                    Thread.currentThread().getName());
//        });
//
//        String value = asynoCompletableFuture.get();
//        System.out.println("value = " + value);
//        System.out.println("starting........");
//    }

        /**
         * 合并操作
         **/
        // reactive -> flatMap 有点像
        CompletableFuture asynoCompletableFuture = CompletableFuture.supplyAsync(() -> {
            // 获取数据操作，假设来自于数据库
            return String.format("[Thread: %s ]hello。。。。\n",
                    Thread.currentThread().getName());
        }).thenApply(value -> {
            return value + "---来自于数据库";
        }).thenApply(value -> {
            int i = 1 / 0;
            return value + " at " + LocalDate.now();
        }).thenApply(value -> {
            System.out.println(value);
            return value;
        }).thenRun(() -> {
            System.out.println("操作结束");
        }).exceptionally(CompletableFutureDemo::apply);

//        while (!asynoCompletableFuture.isDone()) {
//
//        }

        System.out.println("starting........");

        System.in.read();
    }

    private static Void apply(Throwable throwable) {
        System.out.println(throwable);
        return null;
    }

}
