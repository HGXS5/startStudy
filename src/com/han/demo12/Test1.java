package com.han.demo12;

/**
 * 饿汉式单例模式
 */
public class Test1 {
    private Test1(){}
    private static Test1 instance = new Test1();
    public static Test1 getInstance(){
        return instance;
    }
}
