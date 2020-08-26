package org.akanami.juc.CountDownLatchs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Demo01 {
    static final int THREAD_COUNT = 10;

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);

        for(int i = 0; i < THREAD_COUNT; i++) {
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName() + " executing");

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("task finished");
    }
}
