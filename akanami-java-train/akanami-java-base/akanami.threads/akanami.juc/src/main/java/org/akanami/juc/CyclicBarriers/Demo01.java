package org.akanami.juc.CyclicBarriers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Demo01 {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println(" --------------------------- CyclicBarrier Task Processed --------------------------- ");
        });

        for(int i = 1; i <= 7; i++) {
            final int temp = i;

            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " task" + temp + " accessed");

                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        System.out.println("======================================================= all tasks finished =======================================================");
    }
}
