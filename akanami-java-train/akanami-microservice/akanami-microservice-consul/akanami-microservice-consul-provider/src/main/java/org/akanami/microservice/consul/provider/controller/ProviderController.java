package org.akanami.microservice.consul.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @GetMapping("/provider/hello")
    public String hello() {
        return " hello from provider ";
    }
}
