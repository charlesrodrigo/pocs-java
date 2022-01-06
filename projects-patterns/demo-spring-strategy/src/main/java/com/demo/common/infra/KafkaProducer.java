package com.demo.common.infra;

import com.demo.common.domain.entity.Person;

public interface KafkaProducer {

  void send(Person person);
}
