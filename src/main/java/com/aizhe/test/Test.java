package com.aizhe.test;

/**
 * @ClassName Test
 * @Description TODO
 * @Author wangjiaming
 * @Date 2021/3/21 18:31
 */
public class Test {

    public static void main(String[] args) {
        int grade = 59;
        char level = getGradeLevel(grade);
        System.out.println(level);
    }

    private static char getGradeLevel(int grade) {
        return grade >= 90 ? 'A': grade <= 89 && grade >= 60 ? 'B':'C';
    }

}
