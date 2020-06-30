package org.akanami.springboot.annotation.condition.missingclass;

import org.akanami.springboot.annotation.condition.missingbean.component.Component01;
import org.akanami.springboot.annotation.condition.missingbean.component.Component02;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MissingClassConfiguration {
    @Bean
    @ConditionalOnClass(name = { "org.akanami.springboot.annotation.condition.missingbean.component.Component01" })
    public Component01 getComponent01() {
        return new Component01();
    }

    @Bean
    @ConditionalOnMissingClass(value = {"org.akanami.springboot.annotation.condition.missingbean.component.Component02"})
    public Component02 getComponent02() {
        return new Component02();
    }
}
