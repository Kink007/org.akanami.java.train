package org.akanami.chapter16;

/*
    增加参数 -XX:+PrintGCDetails
 */
public class LocalVarGC {
    public void localVarGC1() {
        byte[] buf = new byte[10*1024*1024];
        System.gc();
    }

    public void localVarGC2() {
        byte[] buf = new byte[10*1024*1024];
        buf = null;
        System.gc();
    }

    //buf会存放至局部变量表 索引为1的位置 因此不会回收
    public void localVarGC3() {
        {
            byte[] buf = new byte[10*1024*1024];
        }
        System.gc();
    }

    //因为定义了新的变量，并且buf超出了作用域，局部变量表中复用buf的索引，所以可以回收
    public void localVarGC4() {
        {
            byte[] buf = new byte[10*1024*1024];
        }
        int value = 10;
        System.gc();
    }

    public void localVarGC5() {
        localVarGC1();
        System.gc();
    }

    public static void main(String[] args) {
        LocalVarGC local = new LocalVarGC();
        local.localVarGC1();
        //local.localVarGC2();
        //local.localVarGC3();
        //local.localVarGC4();
        //local.localVarGC5();
        try {
            Thread.sleep(100000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
