package com.zc.week04;

import java.time.LocalDateTime;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: zhangc
 * @date: 2021/2/7
 * @desc:
 */
public class Test07_Semaphore {


    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        long startTime = System.currentTimeMillis();
        Semaphore semaphore = new Semaphore(1);
        AtomicInteger result = new AtomicInteger();
        Thread thread = new Thread(() -> {
            System.out.println(LocalDateTime.now()  + " 异步");
            try {
                semaphore.acquire();
                result.set(sum());
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        thread.start();
        System.out.println(LocalDateTime.now()  + " 同步等待");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.acquire();
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis() - startTime) + " ms");
        semaphore.release();
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
