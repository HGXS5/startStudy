package com.han.demo6;

import java.util.Set;
import java.util.TreeSet;

public class Test2 {
    public static void main(String[] args) {
        Set<Test1> set = new TreeSet<>();
        set.add(new Test1("小狗子", 23));
        set.add(new Test1("小猫子", 33));
        set.add(new Test1("小鱼子", 13));
        set.add(new Test1("小牛子", 43));

        for (Test1 test : set) {
            System.out.println(test);
        }
    }
}
