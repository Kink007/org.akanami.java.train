package org.akanami.springboot.annotation.condition.onpropertys;

import org.akanami.springboot.annotation.condition.missingbean.component.Component01;
import org.akanami.springboot.annotation.condition.missingbean.component.Component02;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OnPropertyConfiguration {

    @Bean
    @ConditionalOnProperty(value = "akanami.onpropertys.component01.enable", havingValue = "true",  matchIfMissing = false)
    public Component01 getComponent01() {
        return new Component01();
    }

    @Bean
    @ConditionalOnProperty(value = "akanami.onpropertys.component02.enable", havingValue = "true",  matchIfMissing = false)
    public Component02 getComponent02() {
        return new Component02();
    }
}
