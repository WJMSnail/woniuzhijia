package com.aizhe.concurrent;

import java.util.concurrent.*;
import java.util.function.Function;

/**
 * @ClassName ThreadPoolDemo
 * @Description 线程池：3大方法、7大参数、4大拒绝策略
 * @Author wangjiaming
 * @Date 2021/3/11 23:28
 */
public class ThreadPoolDemo2 {

    /**
     * cpu密集型
     * io密集型
     * @param args
     */
    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = new ThreadPoolExecutor(
                2,
                processors,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        try {
            for (int i = 0; i < 9; i++) {
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
