package org.akanami.spring.resource_2.resource_2_3.resource_2_3_1;

import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;

public class UrlResourceDemo01 {
    public static void main(String[] args) {
        try {
            UrlResource urlResource = new UrlResource("http|ftp");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
