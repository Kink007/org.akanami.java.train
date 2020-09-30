package org.akanami.spring.ioc_1.bean_1_10.bean_1_10_3;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class AutoDetectClassDemo01Test {

    @Test
    public void testGetMockerCaller() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("/ioc_1/bean_1_10/bean_1_10_3/AutoDetectClassDemo01.xml");
        MockerCaller caller = applicationContext.getBean(MockerCaller.class);

        Assert.assertNotNull(caller);
    }
}