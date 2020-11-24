package com.han.demo5;

import java.util.ArrayList;
import java.util.Arrays;

public class Test10 {
    public static void main(String[] args) {
        //将数组中的元素添加到集合中
        ArrayList<Object> list = new ArrayList<>();
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        Object[] s = delCreatArray(arr);
//        String s1 = Arrays.toString(s);
//        int i = fristArray(arr);


    }

    public static Integer[] delCreatArray(Integer[] arr) {
        if (arr==null || arr.length<1){
            return arr;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        list.remove(0);
        Object[] array = list.toArray();
//        System.out.println(array);
        Integer in = new Integer(array.length);
        Integer[] integers = Arrays.copyOfRange(array, 0, array.length, Integer[].class);
        return integers;
    }


}
