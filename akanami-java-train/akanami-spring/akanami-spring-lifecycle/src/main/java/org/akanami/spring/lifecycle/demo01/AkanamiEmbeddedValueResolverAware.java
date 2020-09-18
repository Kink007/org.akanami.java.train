package org.akanami.spring.lifecycle.demo01;

import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Component
public class AkanamiEmbeddedValueResolverAware implements EmbeddedValueResolverAware {
    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        DemoPrinter.log(5, EmbeddedValueResolverAware.class, "AkanamiEmbeddedValueResolverAware setEmbeddedValueResolver:" + resolver);
    }
}
