package org.akanami.microservice.eureka.client.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    @Qualifier(value = "nobalance")
    RestTemplate restTemplate;

    @Autowired
    @Qualifier(value = "balance")
    RestTemplate autoBalanceRestTemplate;


    @GetMapping("/hello")
    public String hello() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("AKANAMI-MICROSERVICE-EUREKA-CLIENT-PROVIDER");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hello";
        String result = this.restTemplate.getForObject(url, String.class);

        return "Consumer Call Provider return:" + result;
    }

    @GetMapping("/hello1")
    public String hello1() {
        //如果此处想直接使用服务名访问，则必须在注入RestTemplate的时候添加上 @LoadBalance注解
        String result = this.autoBalanceRestTemplate.getForObject("http://AKANAMI-MICROSERVICE-EUREKA-CLIENT-PROVIDER/hello", String.class);

        return "Consumer Call With no balance Provider return:" + result;
    }
}
