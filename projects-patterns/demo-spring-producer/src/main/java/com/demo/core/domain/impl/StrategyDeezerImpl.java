package com.demo.core.domain.impl;

import com.demo.core.domain.Person;
import com.demo.core.domain.Strategy;
import com.demo.core.domain.StrategyName;
import com.demo.core.infra.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("RULE_DEEZER")
public class StrategyDeezerImpl implements Strategy {

  private final Logger log = LoggerFactory.getLogger(StrategyDeezerImpl.class);
  private final KafkaProducer producer;

  public StrategyDeezerImpl(KafkaProducer producer) {
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

  @Override
  public StrategyName getStrategyName() {
    return StrategyName.RULE_DEEZER;
  }
}
