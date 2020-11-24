package com.han.demo6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    public static void main(String[] args) {
        Account account = new Account();
        //newFixedThreadPool:官方是说:创建一个线程池，该线程池重用在共享的无边界队列上运行的固定数量的线程
        //个人理解这个方法就是：创建一定数量的线程池，最大运行数量就是设置的线程数量。
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (int i = 1; i <= 100; i++) {
            //execute()在将来的某个时间执行给定的命令
            executorService.execute(new AddMoneyThread(account,1));
        }
        /**
         * 1.shutdown()方法允许终止之前执行的先前提交的任务
         * 2.shutdownNow()方法可防止等待的任务启动并尝试停止当前正在执行的任务。
         * 3.isTerminated()方法如果所有任务在关闭后都已经完成，则返回true
         */
        executorService.shutdown();
        while (!executorService.isTerminated()){
            System.out.println("我还没有完成，还挺长...");
        }
        System.out.println("账户余额："+account.getBalance());
       // System.exit(0)//使jvm强制终止运行
        //Semaphore或CountdownLatch来实现同步
    }
}
