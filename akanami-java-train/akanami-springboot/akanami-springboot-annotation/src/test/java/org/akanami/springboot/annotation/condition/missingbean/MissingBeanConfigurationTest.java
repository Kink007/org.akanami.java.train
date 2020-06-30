package org.akanami.springboot.annotation.condition.missingbean;

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
 * 注册Component01的时候选择了@ConditionalOnBean(value = NotLoadedComponent.class) 这个注解
 * 注册Component02的时候选择了@ConditionalOnMissingBean(value = NotLoadedComponent.class) 这个注解
 * NotLoadedComponent 主键不注册在容器中
 * 因此获取Component01的时候会抛出NoSuchBeanDefinitionException异常
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MissingBeanConfiguration.class)
public class MissingBeanConfigurationTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void getComponent01() {
        Assert.assertThrows(NoSuchBeanDefinitionException.class, () -> this.applicationContext.getBean(Component01.class));
    }

    @Test
    public void getComponent02() {
        Component02 bean = this.applicationContext.getBean(Component02.class);
        Assert.assertNotNull(bean);
    }
}