package com.aizhe.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName TikitDemo
 * @Description TODO
 * @Author wangjiaming
 * @Date 2021/3/8 22:29
 */
public class TiketDemo {

    static List<String> tickets = new ArrayList<>();

    static Lock lock = new ReentrantLock();

    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票编号："+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() ->{
                lock.lock();
                try {
                    while (tickets.size() > 0){
                        System.out.println(Thread.currentThread().getName() + "销售了--" + tickets.remove(0));
                    }
                }finally {
                    lock.unlock();
                }
            },"窗口：" + i).start();
        }
    }


}
