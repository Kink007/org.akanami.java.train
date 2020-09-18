package org.akanami.spring.lifecycle.beanPostProcessorDemo01.mock;

public class WomanSpeaker implements Speak {
    @Override
    public void say() {
        System.out.println("WomanSpeaker");
    }
}
