package com.han.demo6;

public class AddMoneyThread implements Runnable{
    private Account account;//存入账户
    private double money;//存入金额

    public AddMoneyThread(Account account, double money) {
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
        //第三种：在synchronized代码块的修饰下进行
//        synchronized(account){
//            account.deposit(money);
//        }
        account.deposit(money);
    }
}
