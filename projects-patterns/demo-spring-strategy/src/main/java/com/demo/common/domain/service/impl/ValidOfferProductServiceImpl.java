package com.demo.common.domain.service.impl;

import com.demo.common.domain.entity.Person;
import com.demo.common.domain.entity.Product;
import com.demo.common.domain.service.StrategyService;
import com.demo.common.domain.service.ValidOfferProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ValidOfferProductServiceImpl implements ValidOfferProductService {

  private final Logger log = LoggerFactory.getLogger(ValidOfferProductServiceImpl.class);

  private final Map<String, StrategyService> strategies;

  public ValidOfferProductServiceImpl(Map<String, StrategyService> strategies) {
    this.strategies = strategies;
  }

  @Override
  public void execute(Person person, Product product) {
    log.info("Using Map");
    StrategyService strategy = strategies.get(product.strategy().toString());
    strategy.execute(person);
  }
}
