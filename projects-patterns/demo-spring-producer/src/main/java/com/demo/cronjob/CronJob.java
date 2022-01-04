package com.demo.cronjob;

import com.demo.core.config.ConfigProperties;
import com.demo.core.domain.PersonService;
import com.demo.core.domain.ValidOfferProduct;
import com.demo.core.infra.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CronJob {
  private final Logger log = LoggerFactory.getLogger(CronJob.class);
  private final PersonService personService;
  private final KafkaProducer kafkaProducer;
  private final Optional<ConfigProperties> configProperties;
  private final ValidOfferProduct validOfferProduct;

  public CronJob(
      PersonService personService,
      KafkaProducer kafkaProducer,
      Optional<ConfigProperties> configProperties,
      ValidOfferProduct validOfferProduct) {
    this.personService = personService;
    this.kafkaProducer = kafkaProducer;
    this.configProperties = configProperties;
    this.validOfferProduct = validOfferProduct;
  }

  public void evaluatePerson() {
    var persons = personService.find();

    persons.stream()
        .forEach(
            person -> {
              configProperties
                  .get()
                  .products()
                  .forEach(
                      product -> {
                        log.info("Product {}", product);
                        validOfferProduct.execute(person, product);
                      });
            });
  }
}
