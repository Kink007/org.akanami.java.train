package org.akanami.spring.lifecycle.demo01;

public class DemoPrinter {
    public static void log(int order, Class<?> type, String msg) {
        System.out.println("Spring Bean 生命周期 第" + order + "步  类型:" + type.getName() + " 消息:" + msg);
    }
}
