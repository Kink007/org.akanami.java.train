package org.akanami.spring.ioc_1.bean_1_6_1;

import org.springframework.beans.factory.InitializingBean;

/**
 * We recommend that you do not use the InitializingBean interface,
 * because it unnecessarily couples the code to Spring.
 * Alternatively, we suggest using the @PostConstruct annotation or specifying a POJO initialization method.
 * In the case of XML-based configuration metadata, you can use the init-method attribute to specify the name of the method that has a void no-argument signature.
 * With Java configuration, you can use the initMethod attribute of @Bean.
 */
public class InitMocker implements InitializingBean {
    public static final int AFTER_INIT_FLAG = 6;

    private int flag = 0;

    public int getFlag() {
        return this.flag;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.flag = AFTER_INIT_FLAG;
    }
}
