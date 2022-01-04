package com.demo.core.infra;

import com.demo.core.domain.Person;

public interface KafkaProducer {

  void send(Person person);
}
