package com.demo.cronjob;

import com.demo.common.config.ConfigProperties;
import com.demo.common.domain.service.PersonService;
import com.demo.common.domain.service.ValidOfferProductService;
import com.demo.common.infra.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CronJobService {
  private final Logger log = LoggerFactory.getLogger(CronJobService.class);
  private final PersonService personService;
  private final KafkaProducer kafkaProducer;
  private final Optional<ConfigProperties> configProperties;
  private final ValidOfferProductService validOfferProduct;

  public CronJobService(
      PersonService personService,
      KafkaProducer kafkaProducer,
      Optional<ConfigProperties> configProperties,
      ValidOfferProductService validOfferProduct) {
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
