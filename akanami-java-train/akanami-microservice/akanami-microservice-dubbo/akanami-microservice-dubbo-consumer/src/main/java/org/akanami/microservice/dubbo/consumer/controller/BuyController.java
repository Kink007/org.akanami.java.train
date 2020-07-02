package org.akanami.microservice.dubbo.consumer.controller;

import org.akanami.microservice.dubbo.consumer.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyController {

    @Autowired
    BuyService buyService;

    @GetMapping("/buy")
    public String buy() {
        return this.buyService.getTicket();
    }
}
