package org.akanami.spring.ioc_1.bean_1_5_4;

import java.util.Date;

public class PrototypeMocker {
    Date date;

    public PrototypeMocker() {
        this.date = new Date();
    }

    public Date getDate() {
        return this.date;
    }
}
