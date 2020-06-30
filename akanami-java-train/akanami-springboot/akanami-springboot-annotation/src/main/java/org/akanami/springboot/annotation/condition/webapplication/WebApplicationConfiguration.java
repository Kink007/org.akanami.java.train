package org.akanami.springboot.annotation.condition.webapplication;

import org.akanami.springboot.annotation.condition.missingbean.component.Component01;
import org.akanami.springboot.annotation.condition.missingbean.component.Component02;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebApplicationConfiguration {

    @Bean
    @ConditionalOnWebApplication
    public Component01 getComponent01() {
        return new Component01();
    }

    @Bean
    @ConditionalOnNotWebApplication
    public Component02 getComponent02() {
        return new Component02();
    }
}
