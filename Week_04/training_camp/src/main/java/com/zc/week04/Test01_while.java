package com.zc.week04;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: zhangc
 * @date: 2021/2/7
 * @desc:
 */
public class Test01_while {

    private volatile static boolean  flag = true;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        AtomicInteger result = new AtomicInteger();
        new Thread(()->{
            result.set(sum());
            flag = false;
        }).start();

//        sleepTest();
        whileTest();
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis() - startTime) + " ms");
    }

    private static void sleepTest(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void whileTest(){
        while (flag){
            System.out.println("等待异步完成。。。");
        }
        System.out.println("异步完成");
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
