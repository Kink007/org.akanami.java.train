package org.akanami.spring.factorybean.demo01;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Demo01Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Demo01Application.class);
        Mocker mocker = applicationContext.getBean(Mocker.class);
        System.out.println(mocker.getName());
    }
}
