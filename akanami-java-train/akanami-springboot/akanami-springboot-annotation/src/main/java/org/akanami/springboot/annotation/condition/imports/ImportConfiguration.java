package org.akanami.springboot.annotation.condition.imports;

import org.akanami.springboot.annotation.componentscan.pack01.Component01;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value= { Component01.class})
public class ImportConfiguration {

}
