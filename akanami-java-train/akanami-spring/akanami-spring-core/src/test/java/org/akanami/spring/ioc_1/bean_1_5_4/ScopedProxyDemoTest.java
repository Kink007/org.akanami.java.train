package org.akanami.spring.ioc_1.bean_1_5_4;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:scopedProxyBean.xml"})
public class ScopedProxyDemoTest {
    @Test
    public void testScopedProxyDemo() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc_1/bean_1_5_4/scopedProxyDemo.xml");

        SingletonMocker singleton1 = applicationContext.getBean(SingletonMocker.class);
        SingletonMocker singleton2 = applicationContext.getBean(SingletonMocker.class);

        System.out.println(singleton1.getInnerMocker().getClass());
        //实际上内部已经是代理类
        //By default, when the Spring container creates a proxy for a bean that is marked up with the <aop:scoped-proxy/> element, a CGLIB-based class proxy is created.
        Assert.assertFalse(singleton1.getInnerMocker().getClass() == PrototypeMocker.class);
        Assert.assertTrue(singleton1.getInnerMocker() == singleton2.getInnerMocker());
        Assert.assertFalse(singleton1.getInnerMocker().getDate() == singleton2.getInnerMocker().getDate());
    }
}