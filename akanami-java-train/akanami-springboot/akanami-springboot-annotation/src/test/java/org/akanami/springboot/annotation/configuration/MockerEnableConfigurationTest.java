package org.akanami.springboot.annotation.configuration;

import org.akanami.springboot.annotation.configuration.conf.MockConfigurationProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MockerEnableConfiguration.class)
public class MockerEnableConfigurationTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void getMockConfigurationProperties() {
        MockConfigurationProperties bean = this.applicationContext.getBean(MockConfigurationProperties.class);
        Assert.assertNotNull(bean);

        Assert.assertEquals("akanami", bean.getName());
        Assert.assertEquals(33, bean.getAge().intValue());
        Assert.assertEquals(3, bean.getTags().size());
        Assert.assertTrue(bean.getTags().contains("tag1"));
        Assert.assertEquals(3, bean.getMaps().size());
        Assert.assertTrue(bean.getMaps().containsKey("key1"));
        Assert.assertEquals(3, bean.getMaps2().size());
        Assert.assertTrue(bean.getMaps2().containsKey("key1"));
    }
}