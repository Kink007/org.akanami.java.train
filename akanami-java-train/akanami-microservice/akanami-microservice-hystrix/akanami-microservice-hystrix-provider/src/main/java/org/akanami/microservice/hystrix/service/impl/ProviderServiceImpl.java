package org.akanami.microservice.hystrix.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.akanami.microservice.hystrix.service.ProviderService;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String getCorrect() {
        return "线程池:" + Thread.currentThread().getName() + " getCorrect";
    }

//    @Override
//    @HystrixCommand(fallbackMethod = "getTimeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    })
    public String getTimeout() {

        int r = 10 / 0; //如果直接抛出异常，也会放入指定方法处理

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池:" + Thread.currentThread().getName() + " getTimeout";
    }

    public String getTimeoutHandler() {
        return "线程池:" + Thread.currentThread().getName() + " getTimeoutHandler";
    }
}
