package com.han.demo4;

public class Test2 extends Test {
    @Override
    public void test() {
        System.out.println("我是抽象类test被这个test2继承了，并且还重写了我的方法" + this.a + this.b);
    }

    public static int a = 1;
}
