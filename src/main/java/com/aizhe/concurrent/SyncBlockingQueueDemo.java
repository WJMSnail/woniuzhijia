package com.aizhe.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName SyncBlockingQueue
 * @Description 同步队列
 * @Author wangjiaming
 * @Date 2021/3/10 23:47
 */
public class SyncBlockingQueueDemo {



    public static void main(String[] args) {
        BlockingQueue<String> queue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName()+" put 1");
                queue.put("1");
                System.out.println(Thread.currentThread().getName()+" put 2");
                queue.put("2");
                System.out.println(Thread.currentThread().getName()+" put 3");
                queue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T1").start();

        new Thread(() ->{
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(queue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(queue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T2").start();
    }


}
