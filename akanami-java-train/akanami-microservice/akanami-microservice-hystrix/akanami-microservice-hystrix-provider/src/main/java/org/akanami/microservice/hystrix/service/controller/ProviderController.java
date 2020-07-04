package org.akanami.microservice.hystrix.service.controller;

import org.akanami.microservice.hystrix.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @Autowired
    ProviderService providerService;

    @GetMapping("/hystrix/ok")
    public String ok() {
        return this.providerService.getCorrect();
    }

    @GetMapping("/hystrix/timeout")
    public String timeout() {
        return this.providerService.getTimeout();
    }
}
