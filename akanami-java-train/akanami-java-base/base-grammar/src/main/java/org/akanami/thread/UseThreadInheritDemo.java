package org.akanami.thread;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class UseThreadInheritDemo {

    static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("第" + i + "次执行");
                    TimeUnit.SECONDS.sleep(1);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //new MyThread().run();   //注意:这里使用run方法是同步执行，开启新线程必须使用start方法
        new MyThread().start();   //

        try {
            for (int i = 1; i <= 6; i++) {
                System.out.println("第" + i + "次执行 main");
                TimeUnit.SECONDS.sleep(1);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main执行完成");
        System.in.read();
    }
}
