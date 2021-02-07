package com.zc.week04;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: zhangc
 * @date: 2021/2/7
 * @desc:
 */
public class Test04_Wait {


    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Object obj = new Object();
        AtomicInteger result = new AtomicInteger();
        Thread thread = new Thread(() -> {
            synchronized (obj){
                System.out.println(LocalDateTime.now()  + " 异步");
                result.set(sum());
                obj.notify();
            }
        });
        synchronized (obj){
            thread.start();
            System.out.println(LocalDateTime.now()  + " 获取锁");
            obj.wait();
            System.out.println(LocalDateTime.now()  + " 唤醒");
        }

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
