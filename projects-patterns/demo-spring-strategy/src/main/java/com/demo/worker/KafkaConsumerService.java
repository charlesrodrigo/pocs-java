package com.demo.worker;

import com.demo.domain.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
  private final Logger log = LoggerFactory.getLogger(KafkaConsumerService.class);

  @KafkaListener(topics = "${spring.kafka.topic.consumer}")
  public void consumer(Person person) {
    log.info("Person {} receive offer", person);
  }
}
