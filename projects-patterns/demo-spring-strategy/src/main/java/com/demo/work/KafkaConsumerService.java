package com.demo.work;

import com.demo.common.config.ConfigProperties;
import com.demo.common.domain.entity.Person;
import com.demo.common.domain.service.ValidOfferProductService;
import com.demo.common.infra.KafkaProducerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KafkaConsumerService {
  private final Logger log = LoggerFactory.getLogger(KafkaProducerImpl.class);
  private final Optional<ConfigProperties> configProperties;
  private final ValidOfferProductService validOfferProduct;

  public KafkaConsumerService(
      Optional<ConfigProperties> configProperties, ValidOfferProductService validOfferProduct) {
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
