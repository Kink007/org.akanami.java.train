package org.akanami.microservice.dubbo.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.akanami.microservice.dubbo.provider.service.TicketService;
import org.springframework.stereotype.Component;

@Component
@Service
public class TicketServiceImpl implements TicketService {
    @Override
    public String getName() {
        return "abc";
    }
}
