package org.akanami.microservice.hystrix.controller;

import org.akanami.microservice.hystrix.service.CircuitBreakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {

    @Autowired
    CircuitBreakerService circuitBreakerService;

    @GetMapping("/circuitbreaker/ok")
    public String ok() {
        return "ok";
    }

    @GetMapping("/circuitbreaker/error/{id}")
    public String error(@PathVariable("id") Integer id) {
        return this.circuitBreakerService.error(id);
    }
}
