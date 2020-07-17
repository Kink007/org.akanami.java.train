package org.akanami.chapter08;

import java.util.Scanner;

/*
    视频地址:https://www.bilibili.com/video/BV1PJ411n7xZ?p=66
    堆空间测试
    参数:
        -Xms<size> : 设置初始堆空间
        -Xmx<size> : 设置最大堆空间

    可以使用 java -X 查看详细的设置
 */
public class HeapTest {
    public static void main(String[] args) {
        System.out.println("程序已启动，输入任意值结束");

        try {
            String next = "";
            Scanner scanner = new Scanner(System.in);

            while (!next.equals("quit")) {
                next = scanner.next();
                System.out.println("您输入的信息为:" + next);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
