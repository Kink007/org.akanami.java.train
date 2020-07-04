package org.akanami.microservice.hystrix.rpc;

import org.springframework.stereotype.Component;

@Component
public class ProviderFallbackService implements ProviderService {
    @Override
    public String ok() {
        return "ProviderFallbackService ok";
    }

    @Override
    public String timeout() {
        return "ProviderFallbackService timeout";
    }
}
