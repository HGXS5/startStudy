package com.han.demo7;

import java.util.concurrent.Callable;

public class Test1 implements Callable<Integer> {
    private int upperBounds;

    public Test1(int upperBounds) {
        this.upperBounds = upperBounds;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("我是call()方法");
        int sum = 0;
        for (int i = 0; i < upperBounds; i++) {
            sum += i;
        }
        return sum;
    }
}
