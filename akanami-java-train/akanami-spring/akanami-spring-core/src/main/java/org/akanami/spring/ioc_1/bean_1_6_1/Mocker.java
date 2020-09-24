package org.akanami.spring.ioc_1.bean_1_6_1;

public class Mocker {
    public static final int AFTER_INIT_FLAG = 5;

    private int flag = 0;

    public void init() {
        this.flag = AFTER_INIT_FLAG;
    }

    public int getFlag() {
        return this.flag;
    }
}
