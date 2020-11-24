package com.han.demo6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Test4   {
    public static void main(String[] args) {
        ArrayList<Test3> test3s = new ArrayList<>();
        test3s.add(new Test3("H", 23));
        test3s.add(new Test3("W", 27));
        test3s.add(new Test3("L", 10));
        test3s.add(new Test3("Z", 50));
        /*
        * 1.通过sort方法的第二个参数传入一个Comparator接口对象
        * 相当于是传入一个比较对象大小的算法到sort中
        * 2.由于Java中没有函数指针、仿函数、委托这样的概念，
        * 因此要将一个算法传入一个方法中唯一的选择就是通过接口回调
        * */
        Collections.sort(test3s, new Comparator<Test3>() {
            @Override
            public int compare(Test3 o1, Test3 o2) {
                return o1.getName().compareTo(o2.getName());//比较学生的姓名
            }
        });
        for (Test3 test3 : test3s) {
            System.out.println(test3);
        }
    }
}
