package org.akanami.microservice.zookeeper.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer/hello")
    public String hello() {
        String msg = this.restTemplate.getForObject("http://akanami-microserivce-zookeeper-providers/hello", String.class);

        return "hello from consumer and provider ==> " + msg;
    }
}
