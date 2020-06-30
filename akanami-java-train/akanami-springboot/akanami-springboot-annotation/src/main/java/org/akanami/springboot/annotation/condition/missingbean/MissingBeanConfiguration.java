package org.akanami.springboot.annotation.condition.missingbean;

import org.akanami.springboot.annotation.condition.missingbean.component.Component01;
import org.akanami.springboot.annotation.condition.missingbean.component.Component02;
import org.akanami.springboot.annotation.condition.missingbean.component.NotLoadedComponent;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MissingBeanConfiguration {

    @Bean
    @ConditionalOnBean(value = NotLoadedComponent.class)
    public Component01 getComponent01() {
        return new Component01();
    }

    @Bean
    @ConditionalOnMissingBean(value = NotLoadedComponent.class)
    public Component02 getComponent02() {
        return new Component02();
    }
}
