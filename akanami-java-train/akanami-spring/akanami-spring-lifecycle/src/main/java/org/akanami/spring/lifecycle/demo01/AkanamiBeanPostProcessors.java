package org.akanami.spring.lifecycle.demo01;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class AkanamiBeanPostProcessors implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        DemoPrinter.log(22, BeanPostProcessor.class, "AkanamiBeanPostProcessors postProcessBeforeInitialization => bean[" + bean + "] beanName[" + beanName + "]" );

        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        DemoPrinter.log(22, BeanPostProcessor.class, "AkanamiBeanPostProcessors postProcessAfterInitialization => bean[" + bean + "] beanName[" + beanName + "]" );

        return null;
    }
}
