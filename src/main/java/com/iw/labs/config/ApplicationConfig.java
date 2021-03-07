package com.iw.labs.config;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import org.modelmapper.ModelMapper;
import io.quarkus.arc.DefaultBean;

@Dependent
public class ApplicationConfig {
   @Produces
   @DefaultBean
   public ModelMapper modelMapper() {
       return new ModelMapper();
   }
}
