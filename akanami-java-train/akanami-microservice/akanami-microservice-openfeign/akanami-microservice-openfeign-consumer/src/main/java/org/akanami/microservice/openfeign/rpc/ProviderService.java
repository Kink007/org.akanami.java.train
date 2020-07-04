package org.akanami.microservice.openfeign.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient("akanami-microservice-eureka-client-provider")
public interface ProviderService {
    @GetMapping("/hello")
    String hello();
}
