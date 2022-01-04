package com.demo.core.domain.impl;

import com.demo.core.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ValidOfferProductImpl implements ValidOfferProduct {

  private final Logger log = LoggerFactory.getLogger(ValidOfferProductImpl.class);

  private final StrategyFactory strategyFactory;
  private final Map<String, Strategy> strategies;

  public ValidOfferProductImpl(StrategyFactory strategyFactory, Map<String, Strategy> strategies) {
    this.strategyFactory = strategyFactory;
    this.strategies = strategies;
  }

  @Override
  public void execute(Person person, Product product) {
    if (product.id().equals("1")) {
      log.info("Using Factory");
      Strategy strategy = strategyFactory.findStrategy(product.strategy());
      strategy.execute(person);
    }

    if (product.id().equals("2")) {
      log.info("Using Map");
      Strategy strategy = strategies.get(product.strategy().toString());
      strategy.execute(person);
    }
  }
}
