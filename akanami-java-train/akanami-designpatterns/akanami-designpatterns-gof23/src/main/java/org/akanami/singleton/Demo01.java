package org.akanami.singleton;

public class Demo01 {
    public static void main(String[] args) {
        System.out.println("SingletonObject:" + SingletonObject.getInstance());
    }
}

/*
    单例模式
    DCL: Double Check Lock
    注意:必须添加上 volatile 关键字
        volatile 关键字有禁止指令重排序的功能
        如果指令重排序，可能会在构造对象时，先分配内存空间，然后将引用指向堆内存，最后调用对象的 init 方法，导致多线程时线程栈上获取的对象副本不正确
 */
class SingletonObject {

    static volatile SingletonObject instance;

    private SingletonObject() {

    }

    public static SingletonObject getInstance() {
        if(instance == null) {
            synchronized (SingletonObject.class) {
                if(instance == null) {
                    instance = new SingletonObject();
                }
            }
        }

        return instance;
    }
}
