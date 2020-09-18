package org.akanami.spring.lifecycle.beanPostProcessorDemo01;

import org.akanami.spring.lifecycle.beanPostProcessorDemo01.mock.Speak;
import org.akanami.spring.lifecycle.beanPostProcessorDemo01.mock.WomanSpeaker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Demo02Application.class)
public class Demo02ApplicationTest {
    @Autowired
    Speak speaker;

    @Test
    public void testWithSpeakBeanPostProcessor() {
        Assert.assertTrue(speaker.getClass() == WomanSpeaker.class);
    }
}