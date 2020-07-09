package org.akanami.nacos.discovery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @GetMapping("/provider/hello")
    public String hello() {
        return "nacos provider hello";
    }
}
