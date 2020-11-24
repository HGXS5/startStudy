package com.han.demo4;

public class Test3 implements Test1 {
    @Override
    public void test1() {
        System.out.println("我是Test1接口，我被Test3实现了，并且重写了我的方法。");
    }
    Test1 test1 = new Test3();
    public static int b = 2;
}
