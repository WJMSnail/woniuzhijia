package com.aizhe.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName ThreadPoolDemo
 * @Description 线程池：3大方法、7大参数、4大拒绝策略
 * @Author wangjiaming
 * @Date 2021/3/11 23:28
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newFixedThreadPool(5);
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i < 100; i++) {
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

}
