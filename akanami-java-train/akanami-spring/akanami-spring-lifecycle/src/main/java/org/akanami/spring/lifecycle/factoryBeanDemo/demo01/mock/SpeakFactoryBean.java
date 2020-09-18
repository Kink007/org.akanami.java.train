package org.akanami.spring.lifecycle.factoryBeanDemo.demo01.mock;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class SpeakFactoryBean implements FactoryBean<Speak> {
    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public Speak getObject() throws Exception {
        return new WomanSpeaker();
    }

    @Override
    public Class<?> getObjectType() {
        return WomanSpeaker.class;
    }
}
