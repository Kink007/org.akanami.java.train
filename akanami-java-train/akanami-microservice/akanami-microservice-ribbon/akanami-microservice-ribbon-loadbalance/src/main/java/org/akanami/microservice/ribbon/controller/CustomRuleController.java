package org.akanami.microservice.ribbon.controller;

import org.akanami.microservice.ribbon.loadbalance.CustomLoadBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class CustomRuleController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    CustomLoadBalance customLoadBalance;

    @GetMapping("/custom/hello")
    public String hello() {
        List<ServiceInstance> instances = this.discoveryClient.getInstances("AKANAMI-MICROSERVICE-EUREKA-CLIENT-PROVIDER");
        ServiceInstance serviceInstance = this.customLoadBalance.getServiceInstance(instances);
        String result = restTemplate.getForObject(serviceInstance.getUri() + "/hello",  String.class);

        return "hello from customrule and call :" + result;
    }
}
