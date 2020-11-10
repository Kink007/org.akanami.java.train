package org.akanami.threads;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockerDemo02 {
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        Thread writeThread = new Thread(new WriteTask(), "WriteThread");
        writeThread.start();
        for(int i = 1; i <= 5; i++) {
            Thread readThread = new Thread(new ReadTask(), "ReadThread - " + String.valueOf( i));
            readThread.start();
        }

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ReadTask implements Runnable {
        public void run() {
            ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

            while (true) {
                try {
                    readLock.lock();
                    System.out.println("do read --- " + Thread.currentThread().getName());

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    readLock.unlock();
                }
            }
        }
    }

    static class WriteTask implements Runnable {
        public void run() {
            ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

            while(true) {
                try {
                    writeLock.lock();

                    System.out.println("do write @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ");

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    writeLock.unlock();

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
