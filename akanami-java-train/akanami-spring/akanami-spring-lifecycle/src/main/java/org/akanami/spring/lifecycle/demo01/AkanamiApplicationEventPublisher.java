package org.akanami.spring.lifecycle.demo01;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AkanamiApplicationEventPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        DemoPrinter.log(7, ApplicationEventPublisherAware.class, "AkanamiApplicationEventPublisher setApplicationEventPublisher:" + applicationEventPublisher);
        publisher = applicationEventPublisher;
    }

    public void publish() {
        publisher.publishEvent("Hello");
    }
}
