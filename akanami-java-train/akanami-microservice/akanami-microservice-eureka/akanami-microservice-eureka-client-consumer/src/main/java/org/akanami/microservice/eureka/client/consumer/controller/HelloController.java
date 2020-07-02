package org.akanami.microservice.eureka.client.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("AKANAMI-MICROSERVICE-EUREKA-CLIENT-PROVIDER");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hello";
        String result = this.restTemplate.getForObject(url, String.class);

        return "Consumer Call Provider return:" + result;
    }
}
