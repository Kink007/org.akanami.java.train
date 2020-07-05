package org.akanami.microservice.hystrix.service;

public interface CircuitBreakerService {

    String ok();

    String error(Integer id);
}
