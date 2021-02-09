package homework;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 * <p>
 * 一个简单的代码参考：
 */
public class Homework03 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        int result = sum(); //这是得到的返回值

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }

    public static void method4() {
        AtomicInteger result = new AtomicInteger();
        new Thread(() -> {
            result.set(sum());
        }).start();


    }

    public static void method3() {
        AtomicInteger result = new AtomicInteger();
        new Thread(() -> {
            result.set(sum());
        }).start();

        while (result.get() != 0) {
            System.out.println(result);
            break;
        }

    }

    public static void method2() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicInteger result = new AtomicInteger();
        new Thread(() -> {
            result.set(sum());
            countDownLatch.countDown();
        }).start();

        try {
            countDownLatch.await();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void method1() {
        Callable result = (Callable<Integer>) () -> sum();
        ExecutorService executorService = Executors.newFixedThreadPool(16);
        Future future = executorService.submit(result);
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }
}
