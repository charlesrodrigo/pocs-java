package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.demo.api", "com.demo.common"})
@ConfigurationPropertiesScan(basePackages = {"com.demo.api", "com.demo.common"})
public class ApplicationApi {

  public static void main(String[] args) {
    SpringApplication.run(ApplicationApi.class, args);
  }
}
