package com.demo.domain.service.impl;

import com.demo.domain.model.Person;
import com.demo.domain.service.StrategyService;
import com.demo.domain.service.EventProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("RULE_SPOTIFY")
public class StrategySpotifyServiceImpl implements StrategyService {

  private final Logger log = LoggerFactory.getLogger(StrategySpotifyServiceImpl.class);
  private final EventProducer producer;

  public StrategySpotifyServiceImpl(EventProducer producer) {
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
}
