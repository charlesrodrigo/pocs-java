package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.demo.api", "com.demo.core"})
@ConfigurationPropertiesScan(basePackages = {"com.demo.api", "com.demo.core"})
public class ApplicationApi {

  public static void main(String[] args) {
    SpringApplication.run(ApplicationApi.class, args);
  }
}
