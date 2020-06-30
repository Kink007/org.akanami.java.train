package org.akanami.springboot.annotation.condition.importresources;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = "classpath:import_resource.xml")
public class ImportResourceConfiguration {
}
