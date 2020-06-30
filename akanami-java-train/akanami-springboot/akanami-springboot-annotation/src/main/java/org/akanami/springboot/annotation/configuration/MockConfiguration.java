package org.akanami.springboot.annotation.configuration;

import org.akanami.springboot.annotation.configuration.conf.MockConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan
//@EnableAutoConfiguration
//@ComponentScan(basePackages = "org.akanami.springboot.annotation.configuration")
@EnableConfigurationProperties(value = {MockConfigurationProperties.class})
public class MockConfiguration {

}
