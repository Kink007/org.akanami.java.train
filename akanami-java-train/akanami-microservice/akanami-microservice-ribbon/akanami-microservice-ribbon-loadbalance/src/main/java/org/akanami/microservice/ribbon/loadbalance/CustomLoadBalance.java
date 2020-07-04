package org.akanami.microservice.ribbon.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface CustomLoadBalance {
    ServiceInstance getServiceInstance(List<ServiceInstance> instances);
}
