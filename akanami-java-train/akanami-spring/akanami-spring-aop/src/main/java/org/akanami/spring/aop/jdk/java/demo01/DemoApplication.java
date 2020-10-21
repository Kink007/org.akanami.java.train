package org.akanami.spring.aop.jdk.java.demo01;


import org.akanami.spring.aop.jdk.java.demo01.aop.AspectInvocationHandler;
import org.akanami.spring.aop.jdk.java.demo01.service.HelloService;
import org.akanami.spring.aop.jdk.java.demo01.service.impl.HelloServiceImpl;

import java.lang.reflect.Proxy;

public class DemoApplication {
    public static void main(String[] args) {
        HelloServiceImpl helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService) Proxy.newProxyInstance(helloService.getClass().getClassLoader(),
                new Class[]{HelloService.class},
                new AspectInvocationHandler(helloService));

        proxy.sayHello();
    }
}
