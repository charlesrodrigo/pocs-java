package com.demo.cronjob.config;

import com.demo.domain.model.Person;
import com.demo.cronjob.reader.PersonOfferReader;
import com.demo.cronjob.write.PersonWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableBatchProcessing
public class PersonOfferJobConfig {

  private static final Integer CHUNK_SIZE = 1;

  @Bean("personOfferStep")
  public Step engineOfferStep(
      StepBuilderFactory stepBuilder,
      PersonOfferReader personOfferReader,
      PersonWriter personWriter) {
    return stepBuilder
        .get("personOfferStep")
        .<List<Person>, List<Person>>chunk(CHUNK_SIZE)
        .reader(personOfferReader)
        .writer(personWriter)
        .build();
  }

  @Bean
  public Job engineOfferJob(
      JobBuilderFactory jobBuilder, @Qualifier("personOfferStep") Step personOfferStep) {
    return jobBuilder.get("personOfferJob").start(personOfferStep).build();
  }
}
