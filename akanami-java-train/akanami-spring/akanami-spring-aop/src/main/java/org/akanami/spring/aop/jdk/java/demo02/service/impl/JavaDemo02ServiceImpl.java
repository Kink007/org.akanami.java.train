package org.akanami.spring.aop.jdk.java.demo02.service.impl;

import org.akanami.spring.aop.jdk.java.demo02.service.JavaDemo02Service;

public class JavaDemo02ServiceImpl implements JavaDemo02Service {
    @Override
    public void sayHello() {
        System.out.println("JavaDemo02ServiceImpl sayHello");
    }
}
