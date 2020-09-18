package org.akanami.spring.lifecycle.beanPostProcessorDemo01.mock;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class SpeakBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(Speak.class.isAssignableFrom(bean.getClass())) {
            return new WomanSpeaker();
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        if(Speak.class.isAssignableFrom(bean.getClass())) {
//            return new WomanSpeaker();
//        }

        return bean;
    }
}
