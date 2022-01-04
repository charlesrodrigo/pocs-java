package com.demo.work;

import com.demo.core.config.ConfigProperties;
import com.demo.core.domain.Person;
import com.demo.core.domain.ValidOfferProduct;
import com.demo.core.infra.KafkaProducerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KafkaConsumerService {
  private final Logger log = LoggerFactory.getLogger(KafkaProducerImpl.class);
  private final Optional<ConfigProperties> configProperties;
  private final ValidOfferProduct validOfferProduct;

  public KafkaConsumerService(
      Optional<ConfigProperties> configProperties, ValidOfferProduct validOfferProduct) {
    this.configProperties = configProperties;
    this.validOfferProduct = validOfferProduct;
  }

  @KafkaListener(topics = "${spring.kafka.topic.producer}")
  public void consume(Person person) {
    log.info("Person receiver {}", person);

    configProperties
        .get()
        .products()
        .forEach(
            product -> {
              log.info("Product {}", product);
            });
  }
}
