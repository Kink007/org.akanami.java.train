package org.akanami.base.resources;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class ReadDemo01 {
    public static void main(String[] args) throws IOException {
        //使用File指向的是项目的根路径，因此此处需要将子工程路径填入
        File file = new File("akanami-java-base/akanami-base/src/main/resources/demo01.properties");
        System.out.println(file);
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.exists());

        //当工程部署到Tomcat中时，按照下面方式，则会抛出异常：FileNotFoundException。
        //原因：Java工程打包部署到Tomcat中时，properties的路径变到顶层（classes下），这是由Maven工程结构决定的。
        //由Maven构建的web工程，主代码放在src/main/java路径下，资源放在src/main/resources路径下，
        // 当构建jar包 或 war包时，JVM虚拟机会自动编译java文件为class文件存放在 target/classes目录下，
        // resource资源下的文件会原封不动的拷贝一份到 target/classes 目录下：
        URL resource = ReadDemo01.class.getClassLoader().getResource("demo01.properties");
        System.out.println(resource);

        InputStream resourceAsStream = ReadDemo01.class.getClassLoader().getResourceAsStream("demo01.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        String value = properties.getProperty("testKey");
        System.out.println(value);

        System.out.println(System.getProperties());
    }
}
