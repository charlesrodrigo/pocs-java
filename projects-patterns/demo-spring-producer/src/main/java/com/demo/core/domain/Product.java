package com.demo.core.domain;

public record Product (
   String id,
   String description,
   boolean acceptAutomatic,
   StrategyName strategy,
   Long timeValidOffer,
   Integer minAge){
}
