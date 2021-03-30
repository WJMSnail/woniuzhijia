package com.aizhe.test;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Main {

    protected UnaryOperator<Integer> factorial = i -> i == 0 ? 1 : i * this.factorial.apply( i - 1 );

    public static void main(String[] args) throws Exception {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        Map<Integer, Integer> collect1 = list.parallelStream().filter(p -> p >= 3 && p <= 6).collect(Collectors.groupingBy(p -> p, Collectors.summingInt(p -> 1)));
        Map<String, String> collect = list.stream().map(e -> String.valueOf(e)).distinct().collect(Collectors.toMap(e -> e, e -> e));
        Integer reduce = list.parallelStream().reduce(0, Integer::sum);
        System.out.println(collect1);
        Callable<Integer> c2 = true ? (() -> 42) : (() -> 24);
        System.out.println(c2.call());
        Callable<Runnable> c1 = () -> () -> { System.out.println("Nested lambda"); };
        c1.call().run();
        System.out.println(new Main().factorial.apply(3));
//        for(Integer i:list){
//            System.out.println(i);
//        }
//        list.forEach(integer -> System.out.println(integer));
//        list.stream().filter(a -> a.equals(1)).forEach(integer -> System.out.println(integer));
//        list.forEach(integer -> {
//            integer += 1;
//        });
//        Runnable r1 = () -> {System.out.println("Hello Lambda!");};
////        r1.run();
//        Callable c1 = () -> {System.out.println("aaa");
//            return 1;
//        };
//        Object call = c1.call();
//        System.out.println(call);
//        ListIterator<Integer> listIterator = list.listIterator();
//        for(String str;listIterator.hasPrevious();)
//        {System.out.print(listIterator.previous().toString()+" ");}
//        ListIterator<Integer> integerListIterator = list.listIterator(2);
//        Iterator<Integer> iterator = list.iterator();
//        while (listIterator.hasNext()){
//            Integer next = listIterator.next();
//            boolean b = listIterator.hasPrevious();
//            Integer previous = listIterator.previous();
//            System.out.println(next);
//            System.out.println(b);
//            System.out.println(previous);
//        }
//        Integer set = list.set(2, 5);
//        list.clear();
//        List<Integer> a = new ArrayList<>();
//        a.add(2);
//        a.add(3);
//        list.retainAll(a);
//        Object[] objects = list.toArray(a.toArray());
//        List<String> clone = (List<String>) list.clone();
    }
}
