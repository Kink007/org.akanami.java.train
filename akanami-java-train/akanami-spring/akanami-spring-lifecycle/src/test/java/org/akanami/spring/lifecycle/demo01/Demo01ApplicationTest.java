package org.akanami.spring.lifecycle.demo01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Demo01Application.class)
public class Demo01ApplicationTest {

    @Autowired
    AkanamiApplicationEventPublisher applicationEventPublisher;

    @Test
    public void testApplicationEventPublisherAware() {
        applicationEventPublisher.publish();
    }
}