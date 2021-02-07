package com.zc.week04;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zhangc
 * @date: 2021/2/7
 * @desc:
 */
public class Test05_Lock {

    private static Lock lock = new ReentrantLock();
    private static Condition condition =lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        AtomicInteger result = new AtomicInteger();
        Thread thread = new Thread(() -> {
            try{
                System.out.println(LocalDateTime.now()  + " 获取锁");
                lock.lock();
                System.out.println(LocalDateTime.now()  + " 异步");
                result.set(sum());
                condition.signal();
            } finally {
                lock.unlock();
                System.out.println(LocalDateTime.now()  + " 释放锁");
            }
        });
        thread.start();
        try{
            lock.lock();
            condition.await();
            // 确保  拿到result 并输出
            System.out.println("异步计算结果为："+result);
            System.out.println("使用时间："+ (System.currentTimeMillis() - startTime) + " ms");
        }finally {
            lock.unlock();
            System.out.println(LocalDateTime.now()  + " 释放锁2");
        }

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
