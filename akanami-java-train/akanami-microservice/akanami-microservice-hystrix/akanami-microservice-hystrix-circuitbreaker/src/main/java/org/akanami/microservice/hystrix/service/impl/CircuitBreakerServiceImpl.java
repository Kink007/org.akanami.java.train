package org.akanami.microservice.hystrix.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.akanami.microservice.hystrix.service.CircuitBreakerService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Component
public class CircuitBreakerServiceImpl implements CircuitBreakerService {

    public String ok() {
        return "ok";
    }

    @HystrixCommand(fallbackMethod = "errorHandler", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String error(@PathVariable("id") Integer id) {
        if(id <0) {
            throw new RuntimeException("*********** id 不能为负数");
        }
        String serialNumber = UUID.randomUUID().toString();
        //int r  = 10 / 0;
        return Thread.currentThread().getName() + "\t " + "调用成功，流水号:" + serialNumber;
    }

    public String errorHandler(Integer id) {
        return "出现错误";
    }
}
