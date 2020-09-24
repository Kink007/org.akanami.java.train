package org.akanami.spring.ioc_1.bean1_3_2;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class InstantitationUseFactoryDemoTest {
    @Test
    public void testCreateBeanByFactory() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("/ioc_1/bean1_3_2/instantitationUseFactoryDemo.xml");
        ClientService client1 = applicationContext.getBean(ClientService.class);
        ClientService client2 = applicationContext.getBean(ClientService.class);

        Assert.assertNotNull(client1);
        Assert.assertNotNull(client2);
        Assert.assertTrue(client1 == client2);
    }
}