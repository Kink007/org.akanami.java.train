package org.akanami.springboot.annotation.condition.importresources;

import org.akanami.springboot.annotation.componentscan.pack01.Component01;
import org.akanami.springboot.annotation.condition.missingbean.component.Component02;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ImportReousrce从指定的配置文件中加载Bean
 *  加载Component01时注解 @ConditionalOnClass(name = { "org.akanami.springboot.annotation.condition.missingbean.component.Component01" })
 *  因为路径上的类是存在的，因此可以加载Component01 至容器中
 *
 *  加载Component02 时注解 @ConditionalOnMissingClass(value = {"org.akanami.springboot.annotation.condition.missingbean.component.Component02"})
 *  因为路径上的类是存在的，因此Component02 不能被注入至容器中
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImportResourceConfiguration.class)
public class ImportResourceConfigurationTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void getComponent01(){
        Component01 bean = this.applicationContext.getBean(Component01.class);
        Assert.assertNotNull(bean);
    }

    @Test
    public void getComponent02() {
        Assert.assertThrows(NoSuchBeanDefinitionException.class, () -> this.applicationContext.getBean(Component02.class));
    }
}