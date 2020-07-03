package org.akanami.microservice.zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProvidersApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProvidersApplication.class, args);
    }
}
