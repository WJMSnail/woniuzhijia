package com.aizhe.function;

import java.util.function.Function;

/**
 * @ClassName FunctionDemo
 * @Description TODO
 * @Author wangjiaming
 * @Date 2021/3/13 22:11
 */
public class FunctionDemo {

    public static void main(String[] args) {
        Function<String, String> function = str -> str;
        System.out.println(function.apply("asd"));
    }
}
