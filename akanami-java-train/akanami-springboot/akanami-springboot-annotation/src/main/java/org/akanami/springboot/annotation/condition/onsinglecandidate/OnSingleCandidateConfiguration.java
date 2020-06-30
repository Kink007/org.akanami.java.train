package org.akanami.springboot.annotation.condition.onsinglecandidate;

import org.akanami.springboot.annotation.condition.missingbean.component.Component01;
import org.akanami.springboot.annotation.condition.missingbean.component.Component02;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class OnSingleCandidateConfiguration {

    @Bean
    public Component01 getComponent() {
        return new Component01();
    }

    @Bean
    public Component01 getComponent01() {
        return new Component01();
    }

    @Bean
    public Component02 getComponent02() {
        return new Component02();
    }

    @Bean
    @Primary
    public Component02 getPrimaryComponent02() {
        return new Component02();
    }
}
