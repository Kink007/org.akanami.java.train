package org.akanami.spring.lifecycle.factoryBeanDemo.demo01.mock;

import org.springframework.stereotype.Component;

@Component
public class ManSpeaker implements Speak {
    @Override
    public void say() {
        System.out.println("ManSpeaker");
    }
}
