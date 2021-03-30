package com.aizhe.tvolatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName AutomicDemo
 * @Description TODO
 * @Author wangjiaming
 * @Date 2021/3/14 22:40
 */
public class AutomicDemo {
    
//    private volatile static int num = 0;
    private volatile static AtomicInteger num = new AtomicInteger();

    public static void add(){
//        num++;
        num.getAndIncrement();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount() > 2){
            Thread.yield();
        }

        System.out.println(num);
    }

}
