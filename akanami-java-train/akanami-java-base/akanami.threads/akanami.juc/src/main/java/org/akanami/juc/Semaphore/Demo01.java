package org.akanami.juc.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Demo01 {

    static final int SemaphorePermits = 1;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire(SemaphorePermits);

                    System.out.println(Thread.currentThread().getName() + "抢到资源");

                    TimeUnit.SECONDS.sleep(1);

                    System.out.println(Thread.currentThread().getName() + "释放资源");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(SemaphorePermits);
                }
            }).start();
        }
    }
}
