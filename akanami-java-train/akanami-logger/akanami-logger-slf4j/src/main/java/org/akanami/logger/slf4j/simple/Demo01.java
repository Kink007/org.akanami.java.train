package org.akanami.logger.slf4j.simple;

import ch.qos.logback.classic.util.ContextInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo01 {
    static {
        System.setProperty(ContextInitializer.CONFIG_FILE_PROPERTY, "logback-spring.xml");
    }

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Demo01.class);
        logger.info("hello from demo01");
    }
}
