package com.aizhe.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName BlockingQuereDemo
 * @Description 阻塞队列
 * @Author wangjiaming
 * @Date 2021/3/10 23:28
 */
public class BlockingQueueDemo {

    private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

    public static void main(String[] args) throws InterruptedException {
        test4();
    }

    static void test1() {
        System.out.println(queue.add("1"));
        System.out.println(queue.add("2"));
        System.out.println(queue.add("3"));
//        System.out.println(queue.add("4"));
        System.out.println(queue.remove());
        System.out.println(queue.element());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
//        System.out.println(queue.remove());
    }

    static void test2() {
        System.out.println(queue.offer("1"));
        System.out.println(queue.offer("2"));
        System.out.println(queue.offer("3"));
//        System.out.println(queue.offer("4"));
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
//        System.out.println(queue.poll());
    }

    static void test3() throws InterruptedException {
        queue.put("1");
        queue.put("2");
        queue.put("3");
//        queue.put("4");
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
    }

    static void test4() throws InterruptedException {
        System.out.println(queue.offer("1"));
        System.out.println(queue.offer("2"));
        System.out.println(queue.offer("3"));
        System.out.println(queue.offer("4", 2, TimeUnit.SECONDS));
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll(2, TimeUnit.SECONDS));
    }

}
