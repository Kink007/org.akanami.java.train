package org.akanami.spring.aop.jdk.annotation.demo01;

import org.akanami.spring.aop.jdk.annotation.demo01.service.HelloService;
import org.akanami.spring.aop.jdk.annotation.demo01.config.DemoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoConfiguration.class);
        HelloService bean = applicationContext.getBean(HelloService.class);
        bean.sayHello();
    }
}
