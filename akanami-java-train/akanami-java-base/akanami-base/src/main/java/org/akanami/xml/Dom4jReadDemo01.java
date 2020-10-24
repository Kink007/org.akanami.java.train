package org.akanami.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.net.URL;
import java.util.List;

public class Dom4jReadDemo01 {
    public static void main(String[] args) throws DocumentException {
        URL resource = Dom4jReadDemo01.class.getClassLoader().getResource("xml/demo01.xml");
        File file = new File(resource.getPath());
        SAXReader reader = new SAXReader();

        Document document = reader.read(file);

        List<Node> nodes = document.selectNodes("/configuration/userList/user");
        for (Node node : nodes) {
            String id = node.selectSingleNode("id").getStringValue();
            String name = node.selectSingleNode("name").getStringValue();

            System.out.println("user id:" + id + " name:" + name);
        }
    }
}
