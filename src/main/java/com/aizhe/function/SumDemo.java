package com.aizhe.function;

import java.util.stream.LongStream;

/**
 * @ClassName SumDemo
 * @Description TODO
 * @Author wangjiaming
 * @Date 2021/3/13 23:17
 */
public class SumDemo {

    public static void main(String[] args) {
        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::max);

        System.out.println(sum);
    }

}
