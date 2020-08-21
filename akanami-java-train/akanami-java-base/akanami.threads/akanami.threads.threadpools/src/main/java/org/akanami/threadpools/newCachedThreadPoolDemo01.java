package org.akanami.threadpools;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class newCachedThreadPoolDemo01 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();

        for(int i = 1; i <= 100; i++) {
            threadPool.submit(new Task("task" + i));
        }

        System.out.println("线程注册完成===================================");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Task implements Runnable {
        private String taskName;

        public Task(String taskName) {
            this.taskName = taskName;
        }

        public void run() {
            System.out.println(this.taskName + " 线程:" + Thread.currentThread().getId() + " executed ");
        }
    }
}
