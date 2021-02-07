package com.zc.week04;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: zhangc
 * @date: 2021/2/7
 * @desc:
 */
public class Test02_CountDownLatch {


    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicInteger result = new AtomicInteger();
        new Thread(()->{
            result.set(sum());
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);
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
