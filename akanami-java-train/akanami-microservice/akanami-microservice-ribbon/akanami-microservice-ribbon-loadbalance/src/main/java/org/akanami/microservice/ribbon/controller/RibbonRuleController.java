package org.akanami.microservice.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonRuleController {

    @Autowired
    RestTemplate restTemplate;


}
