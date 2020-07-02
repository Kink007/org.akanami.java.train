package org.akanami.microservice.dubbo.consumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import org.akanami.microservice.dubbo.consumer.service.BuyService;
import org.akanami.microservice.dubbo.provider.service.TicketService;
import org.springframework.stereotype.Component;

@Component
public class BuyServiceImpl implements BuyService {

    @Reference
    TicketService ticketService;

    @Override
    public String getTicket() {
        return this.ticketService.getName();
    }
}
