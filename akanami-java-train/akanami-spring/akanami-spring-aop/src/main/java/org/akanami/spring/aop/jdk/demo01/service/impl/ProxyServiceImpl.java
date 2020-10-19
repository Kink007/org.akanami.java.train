package org.akanami.spring.aop.jdk.demo01.service.impl;

import org.akanami.spring.aop.jdk.demo01.service.ProxyService;
import org.springframework.stereotype.Component;

@Component
public class ProxyServiceImpl implements ProxyService {
    @Override
    public void sayHello() {
        System.out.println("ProxyServiceImpl sayHello");
    }
}
