package com.han.demo6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行账户
 */
public class Account {
    private Lock accountLock = new ReentrantLock();
    private double balance;//账户余额

    /**
     * 存入金额
     * @param money
     */

    public  void deposit(double money){
        double newBalance = balance + money;
        try {
                    Thread.sleep(10); //模拟业务处理的时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        balance = newBalance;
    }
    /**
     * 获得账户余额
     * @return
     */
    public double getBalance(){
        return balance;
    }
    //第二种：方法上加synchronized修饰符
//    public  synchronized void deposit(double money){
//        double newBalance = balance + money;
//        try {
//                    Thread.sleep(10); //模拟业务处理的时间
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//        balance = newBalance;
//    }
    //第一种：加锁
//    public void deposit(double money){
//        accountLock.lock();
//        try {
//                double newBalance = balance + money;
//                try {
//                    Thread.sleep(10); //模拟业务处理的时间
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                balance = newBalance;
//            }finally {
//            accountLock.unlock();
//        }
//    }



}
