package com.aizhe.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 独占锁 一次只能被一个线程占有
 * 共享锁 可以被多个线程同时占有
 * 读取-读取 可以共存
 * 读取-写入 不能共存
 * 写入-写入 不能共存
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCacheLock myCache = new MyCacheLock();
        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.write(temp + "", temp + "");
            }, String.valueOf(i)).start();
        }
        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.read(temp + "");
            }, String.valueOf(i)).start();
        }
    }

}

class MyCacheLock {

    private Map<String, String> map = new HashMap<>();

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    protected void read(String key) {
        lock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "开始读取");
            String value = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取OK：" + value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }

    }

    protected void write(String key, String value) {
        lock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "开始写入");
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

}

class MyCache {

    private Map<String, String> map = new HashMap<>();

    protected void read(String key) {
        System.out.println(Thread.currentThread().getName() + "开始读取");
        String value = map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取OK：" + value);

    }

    protected void write(String key, String value) {
        System.out.println(Thread.currentThread().getName() + "开始写入");
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "写入OK");
    }

}
