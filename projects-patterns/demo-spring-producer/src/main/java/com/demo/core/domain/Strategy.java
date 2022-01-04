package com.demo.core.domain;

public interface Strategy {
  void execute(Person person);

  StrategyName getStrategyName();
}
