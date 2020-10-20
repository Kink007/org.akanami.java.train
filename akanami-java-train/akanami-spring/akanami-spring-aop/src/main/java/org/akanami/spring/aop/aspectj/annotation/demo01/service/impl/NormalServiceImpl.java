package org.akanami.spring.aop.aspectj.annotation.demo01.service.impl;

import org.akanami.spring.aop.aspectj.annotation.demo01.service.NormalService;
import org.springframework.stereotype.Component;

@Component
public class NormalServiceImpl implements NormalService {
    @Override
    public void sayHello() {
        System.out.println("NormalServiceImpl sayHello");
    }

    @Override
    public void sayBye() {
        System.out.println("NormalServiceImpl sayBye");
    }
}
