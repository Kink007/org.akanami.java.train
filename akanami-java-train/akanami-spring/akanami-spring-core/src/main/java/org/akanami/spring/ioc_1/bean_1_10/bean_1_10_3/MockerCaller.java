package org.akanami.spring.ioc_1.bean_1_10.bean_1_10_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class MockerCaller {

    @Autowired
    MockerCaller caller;

    public MockerCaller getCaller() {
        return this.caller;
    }
}
