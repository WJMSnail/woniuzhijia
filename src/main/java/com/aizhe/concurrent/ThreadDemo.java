package com.aizhe.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ThreadDemo
 * @Description TODO
 * @Author wangjiaming
 * @Date 2021/3/7 16:08
 */
public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();

        Phone phone = new Phone();
        for (int i = 0; i < 10; i++) {
            new Thread(() ->{
                try {
                    lock.lock();
                    phone.sendSms();
                    phone.callPhone();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            },"A").start();
        }

    }

}

class Phone{

    public void sendSms() throws InterruptedException {
        System.out.println("发短信");
    }

    public void callPhone(){
        System.out.println("打电话");
    }

}
