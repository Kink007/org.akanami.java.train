package org.akanami.spring.aop.jdk.annotation.demo01.config;

import org.akanami.spring.aop.jdk.annotation.demo01.service.HelloService;
import org.akanami.spring.aop.jdk.annotation.demo01.aop.DemoAspect;
import org.akanami.spring.aop.jdk.annotation.demo01.service.impl.HelloServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class DemoConfiguration {

    @Bean
    public HelloService getHelloService() {
        return new HelloServiceImpl();
    }

    @Bean
    public DemoAspect getDemoAspect() {
        return new DemoAspect();
    }
}
