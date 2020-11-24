package com.han.demo13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Test1 {
    public static void main(String[] args) {
        Integer[] arr = {};
        ArrayList<Integer> astr = new ArrayList<Integer>(10);
        astr.add(5);
        astr.add(3);
        astr.add(2);
        astr.add(4);
        astr.add(8);
        astr.set(1, 6);
      Integer[] array = astr.toArray(arr);

        System.out.println("排序前");
        System.out.println(Arrays.toString(array));
        BubbleSorter bs = new BubbleSorter();
        //bs.sort(array);
        /**
         * 内部类方式
         */
//        bs.sort(array, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o1, o2);
//            }
//        });
        /**
         * lambda表达式
         */
       bs.sort(array,((o1, o2) -> Integer.compare(o1,o2) ));
        System.out.println("排序后");
        System.out.println(Arrays.toString(array));

    }

}
