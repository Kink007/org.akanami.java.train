package org.akanami.spring.ioc_1.bean_1_5_4;

import java.util.Date;

public class SingletonMocker {
    private PrototypeMocker innerMocker;

    public PrototypeMocker getInnerMocker() {
        return this.innerMocker;
    }

    public void setInnerMocker(PrototypeMocker innerMocker) {
        this.innerMocker = innerMocker;
    }

    public Date getDate() {
        return this.innerMocker.getDate();
    }
}
