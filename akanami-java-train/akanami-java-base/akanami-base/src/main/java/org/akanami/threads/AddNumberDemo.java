package org.akanami.threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 这里使用 volatile 关键字 没有效果
 * 主要原因还是因为 ++ 操作不具有原子性
 * 如果想要得到正确的 必须使用AtomInterger
 */
public class AddNumberDemo {
    private static volatile int num = 0;
    private static AtomicInteger numInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(20);
        for(int i = 0; i < 20; i++) {
            Thread thread = new Thread(new AddClass(latch));
            thread.start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("total:" + num);
        System.out.println("atom total:" + numInteger.get());
    }

    static class AddClass implements Runnable {
        private CountDownLatch countDownLatch;

        public AddClass(CountDownLatch aCountDownLatch) {
            countDownLatch = aCountDownLatch;
        }

        public void run() {
            for(int j = 0; j < 10000; j++) {
                num++;
                numInteger.incrementAndGet();
            }
            synchronized (countDownLatch) {
                countDownLatch.countDown();
            }
        }
    }
}
