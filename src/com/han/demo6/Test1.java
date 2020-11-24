package com.han.demo6;

public class Test1 implements Comparable<Test1>{
    private String name;
    private int age;

    public Test1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Test1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Test1 o) {
//        return this.age - o.age;//比较年龄(年龄升序)
        return o.age-this.age  ;//比较年龄(年龄降序序)
    }
}
