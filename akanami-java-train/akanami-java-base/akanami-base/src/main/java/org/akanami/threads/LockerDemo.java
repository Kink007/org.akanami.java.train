package org.akanami.threads;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockerDemo {
    private static ReentrantLock locker = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task(), "thread1");
        Thread thread2 = new Thread(new Task(), "thread2");

        thread1.start();
        thread2.start();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Task implements Runnable {
        public void run() {
            boolean getLock = false;
            try {
                try {
                    getLock = locker.tryLock(500, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(!getLock) {
                    System.out.println("fail get lock -- " + Thread.currentThread().getName());
                } else {
                    System.out.println("get lock");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                if(getLock) {
                    locker.unlock();
                }
            }
        }
    }
}
