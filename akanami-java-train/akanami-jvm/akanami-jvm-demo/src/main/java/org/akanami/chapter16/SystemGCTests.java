package org.akanami.chapter16;

public class SystemGCTests {
    public static void main(String[] args) {
        new SystemGCTests();
        System.gc();    //不一定每次都执行
        //System.runFinalization();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("执行finalize");
    }
}
