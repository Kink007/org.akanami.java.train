package org.akanami.spring.aop.aspectj.pure.demo01;

import org.akanami.spring.aop.aspectj.pure.demo01.service.AspectJDemo01Service;
import org.akanami.spring.aop.aspectj.pure.demo01.service.aspect.AspectJPureAspect;
import org.akanami.spring.aop.aspectj.pure.demo01.service.impl.AspectJDemo01ServiceImpl;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public class PureDemoApplication {
    public static void main(String[] args) {
        AspectJProxyFactory factory = new AspectJProxyFactory(new AspectJDemo01ServiceImpl());
        factory.addInterface(AspectJDemo01Service.class);
        factory.addAspect(new AspectJPureAspect());

        AspectJDemo01Service proxy = (AspectJDemo01Service)factory.getProxy();
        proxy.sayHello();
    }
}
