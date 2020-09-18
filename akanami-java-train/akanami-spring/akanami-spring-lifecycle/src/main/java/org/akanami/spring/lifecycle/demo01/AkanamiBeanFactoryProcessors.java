package org.akanami.spring.lifecycle.demo01;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class AkanamiBeanFactoryProcessors implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        DemoPrinter.log(21, BeanFactoryPostProcessor.class, "AkanamiBeanFactoryProcessors postProcessBeanFactory:" + beanFactory);
    }
}
