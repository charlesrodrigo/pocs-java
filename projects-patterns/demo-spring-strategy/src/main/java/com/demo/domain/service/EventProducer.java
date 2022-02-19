package com.demo.domain.service;

import com.demo.domain.model.Person;

public interface EventProducer {

  void send(Person person);
}
