package org.akanami.spring.aop.jdk.annotation.demo01.service.impl;

import org.akanami.spring.aop.jdk.annotation.demo01.service.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("Hello world!");
    }
}
