package org.akanami.microservice.hystrix.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "akanami-microservice-hystrix-provider", fallback = ProviderFallbackService.class)
public interface ProviderService {
    @GetMapping("/hystrix/ok")
    String ok();

    @GetMapping("/hystrix/timeout")
    String timeout();
}
