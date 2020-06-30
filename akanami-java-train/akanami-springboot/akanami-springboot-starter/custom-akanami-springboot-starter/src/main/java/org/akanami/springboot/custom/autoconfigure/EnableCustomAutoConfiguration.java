package org.akanami.springboot.custom.autoconfigure;

import org.akanami.springboot.custom.conf.CustomConf;
import org.akanami.springboot.custom.service.CustomService;
import org.akanami.springboot.custom.service.impl.CustomServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {CustomConf.class})
@ConditionalOnProperty(value = "akanami.starter.enable", havingValue = "true", matchIfMissing = false)
public class EnableCustomAutoConfiguration {

    @Bean
    public CustomService getCustomService() {
        return new CustomServiceImpl();
    }
}
