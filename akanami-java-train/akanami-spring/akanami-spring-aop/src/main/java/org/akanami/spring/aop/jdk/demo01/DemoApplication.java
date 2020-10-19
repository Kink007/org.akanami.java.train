package org.akanami.spring.aop.jdk.demo01;

import org.akanami.spring.aop.jdk.demo01.config.DemoConfiguration;
import org.akanami.spring.aop.jdk.demo01.service.ProxyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfiguration.class);
        //context.refresh();
        ProxyService service = context.getBean(ProxyService.class);
        service.sayHello();
    }
}
