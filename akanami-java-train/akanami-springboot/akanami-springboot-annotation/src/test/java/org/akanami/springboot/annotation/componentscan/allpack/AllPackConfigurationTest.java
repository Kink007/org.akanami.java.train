package org.akanami.springboot.annotation.componentscan.allpack;

import org.akanami.springboot.annotation.componentscan.pack01.Component01;
import org.akanami.springboot.annotation.componentscan.pack02.Component02;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * AllPackConfiguration中的ComponentScan扫描整个org.akanami.springboot.annotation.componentscan
 * 这个包中包含Component01和Component02组件，因此从容器中可以获取到这2个组件
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AllPackConfiguration.class)
public class AllPackConfigurationTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void getComponent01() {
        Component01 bean = applicationContext.getBean(Component01.class);
        Assert.assertNotNull(bean);
    }

    @Test
    public void getComponent02() {
        Component02 bean = applicationContext.getBean(Component02.class);
        Assert.assertNotNull(bean);
    }
}