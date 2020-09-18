package org.akanami.spring.lifecycle.factoryBeanDemo.demo01;

import org.akanami.spring.lifecycle.factoryBeanDemo.demo01.mock.SpeakFactoryBean;
import org.akanami.spring.lifecycle.factoryBeanDemo.demo01.mock.WomanSpeaker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FactoryBeanDemo01Application.class)
public class FactoryBeanDemo01ApplicationTest {

    @Autowired
    SpeakFactoryBean speakFactoryBean;

    @Test
    public void testFactoryBean() {
        Assert.assertFalse(speakFactoryBean.isSingleton());
        Assert.assertTrue(speakFactoryBean.getObjectType() == WomanSpeaker.class);
    }
}