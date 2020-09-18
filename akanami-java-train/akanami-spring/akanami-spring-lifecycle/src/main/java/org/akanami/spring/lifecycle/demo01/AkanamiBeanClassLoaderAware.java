package org.akanami.spring.lifecycle.demo01;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.stereotype.Component;

@Component
public class AkanamiBeanClassLoaderAware implements BeanClassLoaderAware {
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        DemoPrinter.log(2, BeanClassLoaderAware.class, "AkanamiBeanClassLoaderAware setBeanClassLoader:" + classLoader);
    }
}
