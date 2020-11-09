package org.akanami.threads;

public class ObjectDemo {
    public static void main(String[] args) {
        Object locker = new Object();
        Thread thread1 = new Thread(new Task1(locker));
        Thread thread2 = new Thread(new Task2(locker));
        Thread thread3 = new Thread(new Task3(locker));

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Task1 implements Runnable {
        private Object locker;

        public Task1(Object alocker) {
            this.locker = alocker;
        }

        public void run() {
            try {
                System.out.println("Task01 start");
                Thread.sleep(5000);
                synchronized (this.locker) {
                    //this.locker.notify();
                    this.locker.notifyAll();
                }
                System.out.println("Task01 notify");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class Task2 implements Runnable {
        private Object locker;

        public Task2(Object alocker) {
            this.locker = alocker;
        }

        public void run() {
            try {
                System.out.println("Task02 start");
                synchronized (this.locker) {
                    this.locker.wait();
                }
                System.out.println("Task02 stop wait");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class Task3 implements Runnable {
        private Object locker;

        public Task3(Object alocker) {
            this.locker = alocker;
        }

        public void run() {
            try {
                System.out.println("Task03 start");
                synchronized (this.locker) {
                    this.locker.wait();
                }
                System.out.println("Task03 stop wait");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
