package com.aizhe.tvolatile;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Demo
 * @Description volatile可见性
 * @Author wangjiaming
 * @Date 2021/3/14 22:18
 */
public class Demo {

    private volatile static int num = 0;


    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (num == 0){

            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        num = 1;

        System.out.println(num);
    }

}
