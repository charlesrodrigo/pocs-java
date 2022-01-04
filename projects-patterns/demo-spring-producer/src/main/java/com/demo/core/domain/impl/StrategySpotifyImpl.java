package com.demo.core.domain.impl;

import com.demo.core.domain.Person;
import com.demo.core.domain.Strategy;
import com.demo.core.domain.StrategyName;
import com.demo.core.infra.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("RULE_SPOTIFY")
public class StrategySpotifyImpl implements Strategy {

  private final Logger log = LoggerFactory.getLogger(StrategyDeezerImpl.class);
  private final KafkaProducer producer;

  public StrategySpotifyImpl(KafkaProducer producer) {
    this.producer = producer;
  }

  @Override
  public void execute(Person person) {
    log.info("Execute Strategy Spotify");

    if (person.getName().contains("a")) {
      log.info("Name contains a");
      producer.send(person);
    } else {
      log.info("Name not contains a");
    }
  }

  @Override
  public StrategyName getStrategyName() {
    return StrategyName.RULE_SPOTIFY;
  }
}
