package org.akanami.spring.lifecycle.demo01;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component(value = "akanamiBeanName")
public class AkanamiBeanNameAware implements BeanNameAware {
    @Override
    public void setBeanName(String name) {
        //System.out.println("AkanamiBeanNameAware:" + name);
        DemoPrinter.log(1, BeanNameAware.class, " AkanamiBeanNameAware setBeanName: " + name);
    }
}
