package org.akanami.thread;

import java.util.concurrent.TimeUnit;

public class UseRunableInheritDemo {
    static class MyRunable implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("第" + i + "次执行 Runnable");
                    TimeUnit.SECONDS.sleep(1);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new MyRunable()).start();

        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("第" + i + "次执行 main");
                TimeUnit.SECONDS.sleep(1);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
