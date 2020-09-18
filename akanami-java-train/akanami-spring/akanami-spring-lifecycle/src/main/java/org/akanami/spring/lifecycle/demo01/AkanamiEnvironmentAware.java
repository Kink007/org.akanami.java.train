package org.akanami.spring.lifecycle.demo01;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AkanamiEnvironmentAware implements EnvironmentAware {
    @Override
    public void setEnvironment(Environment environment) {
        DemoPrinter.log(4, EnvironmentAware.class, "AkanamiEnvironmentAware setEnvironment:" + environment);
    }
}
