package org.akanami.threadpools;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
Java通过Executors提供四种线程池，分别为：
    1、newSingleThreadExecutor
        创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
    2、newFixedThreadPool
        创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
    3、newScheduledThreadPool
        创建一个可定期或者延时执行任务的定长线程池，支持定时及周期性任务执行。
    4、newCachedThreadPoo
        创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 */
public class newSingleThreadExecutorDemo01 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 1; i < 50; i++) {
            executor.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getId() + "开始启动");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(Thread.currentThread().getId() + "执行结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("线程注册完成");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
