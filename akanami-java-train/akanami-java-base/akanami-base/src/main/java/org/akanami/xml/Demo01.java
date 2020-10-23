package org.akanami.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.URL;

public class Demo01 {
    public static void main(String[] args) {
        URL resource = Demo01.class.getClassLoader().getResource("xml/demo01.xml");
        System.out.println(resource);
        File file = new File(resource.getPath());
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document parse = documentBuilder.parse(file);
//            /NodeList childNodes = parse.getChildNodes();/
            NodeList configuration = parse.getElementsByTagName("configuration");
            //String textContent = configuration.item(0).getChildNodes().item(0).getTextContent();
            Node item = configuration.item(0);
            System.out.println(configuration);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
