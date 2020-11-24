package com.han.demo6;

public class Test3 {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Test3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Test3(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
