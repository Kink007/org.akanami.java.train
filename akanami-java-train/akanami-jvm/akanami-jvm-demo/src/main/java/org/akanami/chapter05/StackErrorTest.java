package org.akanami.chapter05;

/*
    https://www.bilibili.com/video/BV1PJ411n7xZ?p=45

    jvm 内存模型中
    栈是可以固定大小或者动态分配大小

    如果固定大小，但是申请的局部变量，栈内容超过了固定大小，则抛出 StackOverFlowError
    如果非固定大小，但是从系统中无法申请到内存了，则抛出 OutOfMemoryError

    本例是演示 StackOverFlowError


 */
public class StackErrorTest {
//    public static void main(String[] args) {
//        main(args);
//    }

    private static int count = 1;

    /*
        -Xss 设置栈大小  本地测试的时候可以使用 Edit Configuration    VM options 中 添加 -Xss256k 来测试
        默认是 10409
        设置后是  2456
     */
    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }
}
