package com.demo.common.domain.service;

import com.demo.common.domain.entity.Person;

public interface StrategyService {
  void execute(Person person);
}
