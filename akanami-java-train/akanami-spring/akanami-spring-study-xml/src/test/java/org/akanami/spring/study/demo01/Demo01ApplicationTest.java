package org.akanami.spring.study.demo01;

import org.akanami.spring.study.mock.MockBean;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo01ApplicationTest {

    ApplicationContext getApplicationContext() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/demo01/app.xml");

        return context;
    }


    @Test
    public void getMockBean() {
        ApplicationContext applicationContext = this.getApplicationContext();
        MockBean bean = applicationContext.getBean(MockBean.class);

        Assert.assertEquals(MockBean.MOCKBEAN_NAME, bean.getName());
    }
}