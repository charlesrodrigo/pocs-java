package com.demo;

import com.demo.cronjob.CronJob;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.demo.cronjob", "com.demo.core"})
@ConfigurationPropertiesScan(basePackages = {"com.demo.cronjob", "com.demo.core"})
public class ApplicationCronJob implements ApplicationRunner {

  private final CronJob cronJob;

  public ApplicationCronJob(CronJob cronJob) {
    this.cronJob = cronJob;
  }

  public static void main(String[] args) {
    System.exit(SpringApplication.exit(SpringApplication.run(ApplicationCronJob.class, args)));
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    cronJob.evaluatePerson();
  }
}
