package org.akanami.spring.factorybean.demo01;

import org.springframework.stereotype.Component;

public class Mocker {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
