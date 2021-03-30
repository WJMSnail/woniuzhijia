package com.aizhe.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @ClassName ArrayListDemo
 * @Description TODO
 * @Author wangjiaming
 * @Date 2021/3/26 21:54
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("张三", 12));
        list.add(new Person("李四", 13));
        list.add(new Person("王五", 11));
        list.add(new Person("赵六", 15));
        list.add(new Person("赵六", 19));
        System.out.println(list);
        TreeSet<Person> collect = list.stream().collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getName))));
        ArrayList<Person> distinctList = list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getName))), ArrayList::new));
        System.out.println(collect);
        System.out.println(distinctList);


    }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Person{

    private String name;

    private int age;

}
