package com.han.demo14;

import com.han.demo13.BubbleSorter;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Integer[] ig = {8, 3, 4, 5, 6, 1, 7, 2};
        BubbleSorter bs = new BubbleSorter();
        bs.sort(ig,(x, y) -> Integer.compare(x, y));
        System.out.println(Arrays.toString(ig));
        final int i = MyUtil.binarySearch(ig, 8);
//        final int i = MyUtil.binarySearch(ig, 7, (x, y) -> Integer.compare(x, y));
        System.out.println(i);
    }
}
