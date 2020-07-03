package org.akanami.microservice.consul.cosumer.controller;

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
        String result = this.restTemplate.getForObject("http://akanami-microservice-consul-provider/provider/hello", String.class);

        return "hello from consumer and provider call:" + result;
    }
}
