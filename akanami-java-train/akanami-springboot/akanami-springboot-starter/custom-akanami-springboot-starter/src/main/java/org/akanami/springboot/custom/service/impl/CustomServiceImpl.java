package org.akanami.springboot.custom.service.impl;


import org.akanami.springboot.custom.conf.CustomConf;
import org.akanami.springboot.custom.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomServiceImpl implements CustomService {

    @Autowired
    CustomConf conf;

    @Override
    public String getName() {
        return this.conf.getName();
    }
}
