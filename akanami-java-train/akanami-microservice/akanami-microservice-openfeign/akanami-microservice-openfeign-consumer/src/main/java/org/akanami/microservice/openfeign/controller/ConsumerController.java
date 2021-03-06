package org.akanami.microservice.openfeign.controller;

import org.akanami.microservice.openfeign.rpc.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    ProviderService providerService;

    @GetMapping("/consumer/hello")
    public String hello() {
        return "hello from openfeign : " + this.providerService.hello();
    }
}
