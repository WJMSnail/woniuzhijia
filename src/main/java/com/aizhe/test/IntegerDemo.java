package com.aizhe.test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @ClassName IntegerDemo
 * @Description TODO
 * @Author wangjiaming
 * @Date 2021/2/22 22:22
 */
public class IntegerDemo {

    public static void main(String[] args) {
        Integer c = 12;
        Integer d = 12;
        System.out.println(c == d); //true
        List<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt("1"));
        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()){
            Integer next = listIterator.next();
        }
    }
}
