package com.zc.week04;


import java.util.concurrent.Callable;

/**
 * @author: zhangc
 * @date: 2021/2/7
 * @desc:
 */
public class Test08_Callable {


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Callable<Integer> callable = Test08_Callable::sum;

        try {
            System.out.println("异步计算结果为："+callable.call());
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
