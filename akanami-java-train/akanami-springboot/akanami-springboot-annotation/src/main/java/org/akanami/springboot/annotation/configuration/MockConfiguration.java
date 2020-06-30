package org.akanami.springboot.annotation.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan              //添加扫描路径
@EnableAutoConfiguration    //启动Spring的自动状态配置
public class MockConfiguration {

}
