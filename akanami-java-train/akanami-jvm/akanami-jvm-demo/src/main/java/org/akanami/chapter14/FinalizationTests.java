package org.akanami.chapter14;

public class FinalizationTests {

    static FinalizationTests obj;

    public static void main(String[] args) {
        try {
            obj = new FinalizationTests();
            obj = null;

            System.gc();
            System.out.println("第一次GC");

            Thread.sleep(2000);
            if (obj == null) {
                System.out.println("the obj is dead");
            } else {
                System.out.println("the obj is still alive");
            }

            System.out.println("第二次GC");
            obj = null;
            System.gc();

            if (obj == null) {
                System.out.println("the obj is dead");
            } else {
                System.out.println("the obj is still alive");
            }
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("开始执行finalize");
        obj = this;
    }
}
