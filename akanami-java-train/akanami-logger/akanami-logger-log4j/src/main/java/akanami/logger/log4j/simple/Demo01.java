package akanami.logger.log4j.simple;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.net.URL;

public class Demo01 {
    public static void main(String[] args) {
        URL resource = Demo01.class.getClassLoader().getResource("log4j_demo01.properties");
        String path = resource.getPath();
        PropertyConfigurator.configure(path);
        Logger logger = Logger.getLogger(Demo01.class);
        logger.info("hello log4j from demo01");
    }
}
