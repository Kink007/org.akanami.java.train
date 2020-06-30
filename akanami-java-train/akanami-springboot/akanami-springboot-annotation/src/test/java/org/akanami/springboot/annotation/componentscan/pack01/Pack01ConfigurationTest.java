package org.akanami.springboot.annotation.componentscan.pack01;

import org.akanami.springboot.annotation.componentscan.pack02.Component02;
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
 * 这里程序的入口类是Pack01Configuration
 * Pack01Configuration与Component01在同一个包下，与Component02不在用一个包下
 * 并且Pack01Configuration配置了ComponentScan只扫描本包，因此从容器中是不能加载Component02这个类的
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Pack01Configuration.class)
public class Pack01ConfigurationTest {

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