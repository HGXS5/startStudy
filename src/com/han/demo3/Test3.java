package com.han.demo3;

public class Test3 {
    public static void main(String[] args) {
        /*
        * String.intern()方法就是扩充常量池的一个方法；当一个String实例str调用
        * intern()方法时，Java查找常量池中是否有相同Unicode的字符串常量，如果有
        * 则返回其的引用，如果没有，则在常量池中增加一个Unicode等于str的字符串并
        * 返回它的引用。
        *
        * */
        String s1 = "hanLiBoSee";
        String s2 = new String("hanLiBoSee");
        String s3 = "hanLiBo";
        String s4 = "See";
        String s5 = "hanLiBo" + "See";
        String s6 = s3 + s4;
        System.out.println(s1==s2);
        System.out.println(s1==s5);
        System.out.println(s1==s6);
        System.out.println(s1==s6.intern());
        System.out.println(s2==s2.intern());
    }
}
