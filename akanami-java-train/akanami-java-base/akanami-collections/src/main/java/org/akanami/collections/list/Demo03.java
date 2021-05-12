package org.akanami.collections.list;

public class Demo03 {

    {
        System.out.println("paragraph 1");
    }

    static {
        System.out.println("static paragraph 1 ");
    }

    {
        System.out.println("paragraph 2");
    }

    static {
        System.out.println("static paragraph 2");
    }

    public  Demo03() {
        System.out.println("constructor");
    }

    {
        System.out.println("paragraph 3");
    }

    static {
        System.out.println("static paragraph 3");
    }

    public static void main(String[] args) {
        new Demo03();
        new Demo03();
        System.out.println("finish");
    }
}
