package org.akanami.microservice.ribbon.loadbalance.impl;

import org.akanami.microservice.ribbon.loadbalance.CustomLoadBalance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CustomLoadBalanceImpl implements CustomLoadBalance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public ServiceInstance getServiceInstance(List<ServiceInstance> instances) {
        int current;
        int next;

        do {
            current = atomicInteger.get();
            next = current + 1;

            if(next >= Integer.MAX_VALUE)
                next = 0;
        } while(!this.atomicInteger.compareAndSet(current, next));

        int index = next % instances.size();

        return instances.get(index);
    }
}
