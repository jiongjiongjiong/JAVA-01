package com.zc.week04;

import java.time.LocalDateTime;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: zhangc
 * @date: 2021/2/7
 * @desc:
 */
public class Test06_CyclicBarrier {


    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        long startTime = System.currentTimeMillis();
        CyclicBarrier barrier = new CyclicBarrier(2);
        AtomicInteger result = new AtomicInteger();
        Thread thread = new Thread(() -> {
            System.out.println(LocalDateTime.now()  + " 异步");
            result.set(sum());
            try {
                System.out.println(LocalDateTime.now()  + " 异步等待");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        System.out.println(LocalDateTime.now()  + " 同步等待");
        barrier.await();
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
