package org.akanami.springboot.annotation.condition.webapplication;

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
 * ImportReousrce从指定的配置文件中加载Bean
 *  加载Component01时注解 @ConditionalOnWebApplication
 *  因为不是Web应用，因此Component01 不能被注入至容器中
 *
 *  加载Component02 时注解  @ConditionalOnNotWebApplication
 *  因为不是Web应用，因此Component02 能被注入至容器中
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplicationConfiguration.class)
public class WebApplicationConfigurationTest {

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