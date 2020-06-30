package org.akanami.springboot.annotation.condition.missingclass;

import org.akanami.springboot.annotation.condition.missingbean.component.Component01;
import org.akanami.springboot.annotation.condition.missingbean.component.Component02;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Component01注册Bean时添加注解
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MissingClassConfiguration.class)
public class MissingClassConfigurationTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void getComponent01() {
        Component01 bean = this.applicationContext.getBean(Component01.class);
        Assert.assertNotNull(bean);
    }

    @Test
    public void getComponent02() {
        Assert.assertThrows(NoSuchBeanDefinitionException.class, () -> this.applicationContext.getBean(Component02.class));
    }
}