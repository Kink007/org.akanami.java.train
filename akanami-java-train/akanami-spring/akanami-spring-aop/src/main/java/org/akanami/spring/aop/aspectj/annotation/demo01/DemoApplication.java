package org.akanami.spring.aop.aspectj.annotation.demo01;

import org.akanami.spring.aop.aspectj.annotation.demo01.service.NormalService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan(basePackageClasses = DemoApplication.class)
@EnableAspectJAutoProxy
public class DemoApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoApplication.class);
        NormalService bean = applicationContext.getBean(NormalService.class);
        bean.sayHello();
        bean.sayBye();
    }
}
