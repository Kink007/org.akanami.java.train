package org.akanami.springboot.annotation.condition.imports;

import org.akanami.springboot.annotation.componentscan.pack01.Component01;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 通过Import将指定的Bean注入容器
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImportConfiguration.class)
public class ImportConfigurationTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void getComponent01() {
        Component01 bean = this.applicationContext.getBean(Component01.class);
        Assert.assertNotNull(bean);
    }
}