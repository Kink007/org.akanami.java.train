package org.akanami.threadpools;

import org.omg.CORBA.TIMEOUT;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class newScheduledThreadPoolDemo01 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        //表示5秒后执行
        scheduledThreadPool.schedule(new Task01("task01"), 5, TimeUnit.SECONDS);
        //延迟5秒，然后每2秒执行一次
        scheduledThreadPool.scheduleAtFixedRate(new Task01("task02"), 5, 2, TimeUnit.SECONDS);

        for(int i = 3; i <= 10; i++) {
            scheduledThreadPool.execute(new Task01("task0" + i));
        }

        System.out.println("线程注册完成===================================");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Task01 implements Runnable {
        private String taskName;

        public Task01(String taskName) {
            this.taskName = taskName;
        }

        public void run() {
            System.out.println(this.taskName + " 线程:" + Thread.currentThread().getId() + " executed ");
        }
    }
}
