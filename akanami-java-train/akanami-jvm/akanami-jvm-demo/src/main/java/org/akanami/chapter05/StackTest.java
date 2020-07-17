package org.akanami.chapter05;

/*
    视频地址: https://www.bilibili.com/video/BV1PJ411n7xZ?p=44
 */
public class StackTest {

    public static void main(String[] args) {
        StackTest test = new StackTest();
        test.methodA();
    }

    public void methodA() {
        int i = 0;
        int j = 1;

        methodB();
    }

    public void methodB() {
        int a = 1;
        int b = 2;
    }
}
