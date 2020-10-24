package org.akanami.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.URL;

public class JdkReadXmlDemo01 {
    public static void main(String[] args) {
        URL resource = JdkReadXmlDemo01.class.getClassLoader().getResource("xml/demo01.xml");
        System.out.println(resource);
        File file = new File(resource.getPath());
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);

            NodeList userList = document.getElementsByTagName("user");

            System.out.println("userList length:" + userList.getLength());
            for(int i = 0; i < userList.getLength(); i++) {
                String id = document.getElementsByTagName("id").item(i).getFirstChild().getNodeValue();

                String name = document.getElementsByTagName("name").item(i).getFirstChild().getNodeValue();

                System.out.println("user id:" + id + " name:" + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
