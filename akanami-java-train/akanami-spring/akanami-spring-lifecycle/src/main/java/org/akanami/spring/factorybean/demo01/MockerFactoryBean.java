package org.akanami.spring.factorybean.demo01;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class MockerFactoryBean implements FactoryBean<Mocker> {
    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public Mocker getObject() throws Exception {
        Mocker mocker = new Mocker();
        mocker.setName("hello");

        return mocker;
    }

    @Override
    public Class<?> getObjectType() {
        return Mocker.class;
    }
}
