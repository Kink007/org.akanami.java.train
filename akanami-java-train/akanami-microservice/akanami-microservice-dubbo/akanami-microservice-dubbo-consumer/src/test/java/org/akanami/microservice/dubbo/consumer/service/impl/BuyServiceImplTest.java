package org.akanami.microservice.dubbo.consumer.service.impl;

import org.akanami.microservice.dubbo.consumer.service.BuyService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuyServiceImplTest {

    @Autowired
    BuyService buyService;

    @Test
    public void getTicket() {
        String ticket = this.buyService.getTicket();

        Assert.assertNotNull(ticket);
        Assert.assertEquals("abc", ticket);
    }
}