package com.aizhe.test;

/**
 * @ClassName Kuohoa
 * @Description TODO
 * @Author wangjiaming
 * @Date 2021/2/25 23:46
 */
public class Kuohoa {

    public static void main(String[] args) {
        String s = "([)]";
        boolean valid = new Kuohoa().isValid(s);
        System.out.println(valid);

    }

    public boolean isValid(String s) {
        int i = "([".indexOf(s);
        if(s.length() % 2 != 0){
            return false;
        }else{
            if( s.contains("(]") ||
                s.contains("({") ||
                s.contains("(}") ||
                s.contains("[)") ||
                s.contains("[{") ||
                s.contains("[}") ||
                s.contains("{)") ||
                s.contains("{(") ||
                s.contains("{)") ||
                s.contains(")}")){
                return false;
            }else{
                return true;
            }
        }

    }
}
