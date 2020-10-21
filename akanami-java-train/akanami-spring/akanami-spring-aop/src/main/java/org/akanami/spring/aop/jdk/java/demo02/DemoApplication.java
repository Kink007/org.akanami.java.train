package org.akanami.spring.aop.jdk.java.demo02;

import org.akanami.spring.aop.jdk.java.demo02.service.JavaDemo02Service;
import org.akanami.spring.aop.jdk.java.demo02.service.aspect.DemoBeforeAdvice;
import org.akanami.spring.aop.jdk.java.demo02.service.impl.JavaDemo02ServiceImpl;
import org.springframework.aop.framework.ProxyFactory;

public class DemoApplication {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new JavaDemo02ServiceImpl());
        proxyFactory.addInterface(JavaDemo02Service.class);
        proxyFactory.addAdvice(new DemoBeforeAdvice());
        JavaDemo02Service proxy = (JavaDemo02Service)proxyFactory.getProxy();
        proxy.sayHello();
    }
}
