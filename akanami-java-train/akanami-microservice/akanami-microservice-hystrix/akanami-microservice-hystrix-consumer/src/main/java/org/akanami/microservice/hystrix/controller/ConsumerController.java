package org.akanami.microservice.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.akanami.microservice.hystrix.rpc.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@DefaultProperties(defaultFallback = "globalHandler", commandProperties = {
//        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//})
public class ConsumerController {

    @Autowired
    ProviderService providerService;

    @GetMapping("/consumer/provider/ok")
    public String ok() {
        return "consumer :" + this.providerService.ok();
    }

    @GetMapping("/consumer/provider/timeout")
//    @HystrixCommand(fallbackMethod = "getTimeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    })
    //@HystrixCommand
    public String timeout() {
        return "consumer :" + this.providerService.timeout();
    }

    public String getTimeoutHandler() {
        return "consumer timeout handler";
    }

    public String globalHandler() {
        return "consumer global handler";
    }
}
