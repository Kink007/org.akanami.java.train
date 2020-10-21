package org.akanami.spring.aop.aspectj.pure.demo01.service.impl;

import org.akanami.spring.aop.aspectj.pure.demo01.service.AspectJDemo01Service;

public class AspectJDemo01ServiceImpl implements AspectJDemo01Service {
    @Override
    public void sayHello() {
        System.out.println("call AspectJDemo01ServiceImpl sayHello");
    }
}
