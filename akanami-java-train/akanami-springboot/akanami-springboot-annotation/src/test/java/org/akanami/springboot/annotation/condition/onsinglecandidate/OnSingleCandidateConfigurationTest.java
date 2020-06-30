package org.akanami.springboot.annotation.condition.onsinglecandidate;

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
 * ConditionalOnSingleCandidate 注解表示指定的Bean在容器中只存在一个，或者有指定Primary的Bean才符合条件
 *
 * Component01组件 注册了2次 未指定Primary 因此无法获取
 * Component02组件 注册了2次 但指定了Primary 因此可以获取
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnSingleCandidateConfiguration.class)
public class OnSingleCandidateConfigurationTest {

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