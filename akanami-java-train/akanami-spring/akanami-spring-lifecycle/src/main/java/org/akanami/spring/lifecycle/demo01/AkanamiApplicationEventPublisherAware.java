package org.akanami.spring.lifecycle.demo01;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class AkanamiApplicationEventPublisherAware implements ApplicationEventPublisherAware {
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        DemoPrinter.log(7, ApplicationEventPublisherAware.class, "AkanamiApplicationEventPublisherAware setApplicationEventPublisher:" + applicationEventPublisher);
    }
}
