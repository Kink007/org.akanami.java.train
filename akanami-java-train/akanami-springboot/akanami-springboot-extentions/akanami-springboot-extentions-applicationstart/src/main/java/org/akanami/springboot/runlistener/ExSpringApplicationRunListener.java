package org.akanami.springboot.runlistener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class ExSpringApplicationRunListener implements SpringApplicationRunListener {

    /**
     * SpringApplicationRunListener文档中建议构造函数中加入这2个参数
     * 需要将配置配置到META-INF/spring.factories中
     * org.springframework.boot.SpringApplicationRunListener=\
     * org.akanami.springboot.listener.ExSpringApplicationRunListener
     * @param springApplication
     * @param args
     */
    public ExSpringApplicationRunListener(SpringApplication springApplication, String[] args) {

    }

    @Override
    public void starting() {
        System.out.println("=========================> ExSpringApplicationRunListener starting ");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("=========================> ExSpringApplicationRunListener environmentPrepared ");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("=========================> ExSpringApplicationRunListener contextPrepared ");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("=========================> ExSpringApplicationRunListener contextLoaded ");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("=========================> ExSpringApplicationRunListener started ");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("=========================> ExSpringApplicationRunListener running ");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("=========================> ExSpringApplicationRunListener failed ");
    }
}
