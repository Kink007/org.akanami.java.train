package org.akanami.thread;

import java.util.concurrent.TimeUnit;

public class UseLambdaDemo {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("第" + i + "次执行 UseLambdaDemo");
                    TimeUnit.SECONDS.sleep(1);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            for (int i = 1; i <= 7; i++) {
                System.out.println("第" + i + "次执行 main");
                TimeUnit.SECONDS.sleep(1);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
