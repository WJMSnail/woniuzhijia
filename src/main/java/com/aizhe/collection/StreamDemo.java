package com.aizhe.collection;

import java.util.*;
import java.util.stream.*;

/**
 * @ClassName StreamDemo
 * @Description TODO
 * @Author wangjiaming
 * @Date 2021/3/26 22:32
 */
public class StreamDemo {

    public static void main(String[] args) {
//        Arrays.stream(new int[]{2, 2}).forEach(System.out::println);
//        Stream<String> stream = Stream.of("a", "b", "c");
//        stream.forEach(System.out::println);
//        IntStream.of(new int[]{1,2,3}).forEach(System.out::println);
//        IntStream.range(1,7).forEach(System.out::println);
//        IntStream.rangeClosed(1,7).forEach(System.out::println);
//        LongStream.of(10,11,12).forEach(System.out::println);
//        DoubleStream.of(11.12, 12.34, 34.33).forEach(System.out::println);
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(4);
        Integer[] strings = list.stream().toArray(Integer[]::new);
        for (Integer s: strings) {
            System.out.println(s);
        }
        List<Integer> collect = new ArrayList<>(list);
        System.out.println(collect);
        HashSet<Integer> collect1 = new HashSet<>(list);
        System.out.println(collect1);
        Set<Integer> collect2 = new HashSet<>(list);
        System.out.println(collect2);
        TreeSet<Integer> collect3 = new TreeSet<>(list);
        System.out.println(collect3);
        TreeSet<Integer> collect4 = new TreeSet<>(list);
        System.out.println(collect4);
        String collect5 = list.stream().map(Object::toString).collect(Collectors.joining(","));
        System.out.println(collect5);
    }

}
