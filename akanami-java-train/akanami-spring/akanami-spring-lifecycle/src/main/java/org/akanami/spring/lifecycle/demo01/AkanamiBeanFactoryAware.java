package org.akanami.spring.lifecycle.demo01;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

@Component
public class AkanamiBeanFactoryAware implements BeanFactoryAware {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        DemoPrinter.log(3, BeanFactoryAware.class, "AkanamiBeanFactoryAware beanFactory:" + beanFactory);
    }
}
