package org.akanami.threadpools;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class newFixedThreadPoolDemo01 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 50; i++) {
            executor.submit(new Task(i));
        }

        System.out.println("线程注册完成---------------------------------------------");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Task implements Runnable {

        public  Task(Integer index) {
            this.index = index;
        }

        private Integer index;

        public Integer getIndex() {
            return this.index;
        }

        public void run() {
            System.out.println("线程" + index.toString() + "开始执行");

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("线程" + index.toString() + "执行结束");
        }
    }
}
