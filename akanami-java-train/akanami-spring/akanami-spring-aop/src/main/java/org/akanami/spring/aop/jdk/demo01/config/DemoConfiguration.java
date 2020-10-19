package org.akanami.spring.aop.jdk.demo01.config;

import org.akanami.spring.aop.jdk.demo01.aop.AspectService;
import org.akanami.spring.aop.jdk.demo01.service.ProxyService;
import org.akanami.spring.aop.jdk.demo01.service.impl.ProxyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfiguration {

    @Bean
    public ProxyService getProxyService() {
        return new ProxyServiceImpl();
    }

    @Bean
    public AspectService getAspectService() {
        return new AspectService();
    }
}
