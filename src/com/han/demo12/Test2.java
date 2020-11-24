package com.han.demo12;

/**
 * 懒汉式单例
 */
public class Test2 {
    private static Test2 instance = null;
    private Test2(){}
    public static synchronized Test2 getInstance(){
        if (instance == null){
            instance = new Test2();
        }
        return instance;
    }
}
