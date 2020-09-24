package org.akanami.spring.ioc_1.bean_1_6_1;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class InitializationCallbacksDemoTest {
    @Test
    public void testInit() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc_1/bean_1_6_1/initializationCallbacksDemo.xml");
        Mocker bean = applicationContext.getBean(Mocker.class);

        Assert.assertTrue(bean.getFlag() == Mocker.AFTER_INIT_FLAG);
    }

    @Test
    public void testInitialingBean() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc_1/bean_1_6_1/initializationCallbacksDemo.xml");
        InitMocker bean = applicationContext.getBean(InitMocker.class);

        Assert.assertTrue(bean.getFlag() == InitMocker.AFTER_INIT_FLAG);
    }
}