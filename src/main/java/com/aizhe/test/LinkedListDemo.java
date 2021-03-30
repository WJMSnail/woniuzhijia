package com.aizhe.test;

/**
 * @ClassName LinkedListDemo
 * @Description TODO
 * @Author wangjiaming
 * @Date 2020/12/25 23:32
 */
public class LinkedListDemo {

    public static void main(String[] args) {
//        List<Integer> list = new LinkedList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.remove(2);
//        list.add(4);
//        list.add(5);
//        list.add(3, 8);
//        List<String> strings = new ArrayList<>();
//        strings.add("1");
//        STRINGS.ADD("2");
//        strings.add("3");
//        System.out.println(list);
        int a = 15; //1111 0111
        a = a | a >> 1;
//        a |= a >> 1;
        System.out.println(a);
//        Map<String, Object> map = Collections.synchronizedMap(new HashMap<String, Object>());
        new Object(){
            void show(){
                System.out.println("show run");
            }
        }.show();
    }
}
