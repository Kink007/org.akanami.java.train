package org.akanami.chapter16;

import java.util.ArrayList;
import java.util.Scanner;

public class StopTheWorldDemo {

    public static void main(String[] args) {
        Thread gcThread = new Thread(() -> {
            ArrayList<byte[]> list = new ArrayList<byte[]>();

            while (true) {
                for (int i = 0; i < 1000; i++) {
                    list.add(new byte[1024]);
                }

                if (list.size() > 100000) {
                    list.clear();
                    System.gc();

                    System.out.println("垃圾回收完成");
                }
            }
        });

        Thread printThread = new Thread(() -> {
            long start = System.currentTimeMillis();


            try {
                while (true) {
                    long timeSpan = System.currentTimeMillis() - start;
                    System.out.println(timeSpan / 1000 + "." + timeSpan % 1000);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        gcThread.start();
        printThread.start();

        new Scanner(System.in).next();
    }
}
