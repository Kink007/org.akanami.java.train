package org.akanami.juc.violatiles;

/*
    正常的输出结果应该是 20000
    但是实际是小于 20000 因为操纵不具有原子性
 */
public class Demo01 {
    public static void main(String[] args) {
        Task task = new Task();

        Thread thread01 = new Thread(task);
        Thread thread02 = new Thread(task);

        thread01.start();
        thread02.start();

        while( Thread.activeCount() > 2) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("result:" + task.getCount());
    }

    static class Task implements Runnable {
        static int count;

        public int getCount() {
            return count;
        }

        @Override
        public void run() {
            for(int i = 0; i < 10000; i++) {
                count++;
            }
        }
    }
}
