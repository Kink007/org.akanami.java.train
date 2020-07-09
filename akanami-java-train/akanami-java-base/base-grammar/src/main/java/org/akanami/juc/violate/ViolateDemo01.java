package org.akanami.juc.violate;

class Mock {
    //volatile int number = 0;
    int number = 0;

    public void addTo60() {
        this.number = 60;
    }
}

public class ViolateDemo01 {
    public static void main(String[] args) {
        Mock mock = new Mock();

        new Thread(() -> {
            System.out.println("before the number is :" + mock.number + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mock.addTo60();
            System.out.println("after the number is :" + mock.number + " " + Thread.currentThread().getName());
        }, "AAA").start();

        while (mock.number != 60) {
            //注释这段代码 可见性是可以证明的
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

        System.out.println("the number changed:" + Thread.currentThread().getName());
    }
}
