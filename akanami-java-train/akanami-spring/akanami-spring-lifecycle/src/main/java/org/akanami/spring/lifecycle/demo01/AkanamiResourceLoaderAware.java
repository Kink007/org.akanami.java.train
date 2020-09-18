package org.akanami.spring.lifecycle.demo01;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class AkanamiResourceLoaderAware implements ResourceLoaderAware {
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        DemoPrinter.log(6, ResourceLoaderAware.class, "AkanamiResourceLoaderAware setResourceLoader:" + resourceLoader);
    }
}
