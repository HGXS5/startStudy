package test;

import com.han.demo7.Test1;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList<Future<Integer>> lists = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            //submit()方法表示提交要执行的返回值任务，并返回任务的未决结果的Future
            lists.add(executorService.submit(new Test1((int) (Math.random() * 100))));
        }
        // 关闭后，call()就没有返回值了
        //executorService.shutdown();
        /**
         * isTerminated()方法如果所有任务在关闭后都已经完成，则返回true
         */
        if (executorService.isTerminated()){
            System.out.println("我是那个线程池，所有任务已经执行完毕了");
        }else{
            int sum = 0;
            for (Future<Integer> list : lists) {
                //isDone()方法是表示，该任务完成返回true
                sum += list.get();
            }
            System.out.println(sum);
        }
    }
}

