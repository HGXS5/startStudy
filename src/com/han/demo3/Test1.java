package com.han.demo3;

public class Test1 {
    public static void test(int a, int b){
        int temp;
        temp = b;
        b = a;
        a = temp;
        System.out.println("方法中的a,b："+a+b);
    }
    public static void main(String[] args) {
        Test2 t2 = new Test2();
        t2.test2();
        System.out.println("通过封装类中的方法a,b："+t2.a+t2.b);
        int a =4;
        int b =8;
        System.out.println("调用方法之前的a,b："+a+b);
       //test(4,8);
        test(a,b);
        System.out.println("调用方法之后的a,b："+a+b);
    }
}
