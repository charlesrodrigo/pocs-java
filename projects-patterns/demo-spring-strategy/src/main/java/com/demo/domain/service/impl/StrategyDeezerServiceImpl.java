package com.demo.domain.service.impl;

import com.demo.domain.model.Person;
import com.demo.domain.service.StrategyService;
import com.demo.domain.service.EventProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("RULE_DEEZER")
public class StrategyDeezerServiceImpl implements StrategyService {

  private final Logger log = LoggerFactory.getLogger(StrategyDeezerServiceImpl.class);
  private final EventProducer producer;

  public StrategyDeezerServiceImpl(EventProducer producer) {
    this.producer = producer;
  }

  @Override
  public void execute(Person person) {
    log.info("Execute Strategy Deezer");

    if (person.getName().contains("b")) {
      log.info("Name contains b");
      producer.send(person);
    } else {
      log.info("Name not contains b");
    }
  }
}
