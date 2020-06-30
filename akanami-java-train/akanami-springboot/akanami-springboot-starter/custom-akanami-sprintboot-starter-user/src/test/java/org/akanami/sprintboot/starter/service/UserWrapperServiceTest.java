package org.akanami.sprintboot.starter.service;

import org.akanami.springboot.custom.service.CustomService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserWrapperServiceTest {

    @Autowired
    CustomService customService;

    @Test
    public void getStarterCustomService() {
        Assert.assertNotNull(this.customService);
        Assert.assertEquals("akanami", this.customService.getName());
    }
}