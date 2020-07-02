package org.akanami.microservice.eureka.client.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Bean(value = "nobalance")
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean(value = "balance")
    @LoadBalanced
    public RestTemplate getBalanceRestTemplate() {
        return new RestTemplate();
    }
}
