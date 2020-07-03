package org.akanami.innerclass;

public class OuterClass {

    private Integer code = 0;
    private InnerClass inner;

    public OuterClass() {
        this.inner = new InnerClass();
    }

    class InnerClass {
        void test() {
            OuterClass.this.code++;
        }
    }

    public Integer getCode() {
        return this.code;
    }

    public void CallInner() {
        this.inner.test();
    }
}
