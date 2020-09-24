package org.akanami.spring.ioc_1.bean_1_6_1;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class DefaultInitAndDestroyCallbacksDemoTest {
    @Test
    public void testInitWithDefaultConfigure() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc_1/bean_1_6_1/defaultInitAndDestroyCallbacksDemo.xml");
        Mocker bean = applicationContext.getBean(Mocker.class);

        Assert.assertTrue(bean.getFlag() == Mocker.AFTER_INIT_FLAG);
    }
}