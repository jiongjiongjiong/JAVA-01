package com.zc.week04;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: zhangc
 * @date: 2021/2/7
 * @desc:
 */
public class Test09_Future {


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(Test09_Future::sum);
        executorService.shutdown();
        try {
            System.out.println("异步计算结果为："+future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("使用时间："+ (System.currentTimeMillis() - startTime) + " ms");
    }

    private static int sum() {
        return fibo(1);
    }

    private static int fibo(int a) {
        System.out.println("a----" + a);
        if ( a < 2) {
            return 1;
        }
        return fibo(a-1) + fibo(a-2);
    }
}
