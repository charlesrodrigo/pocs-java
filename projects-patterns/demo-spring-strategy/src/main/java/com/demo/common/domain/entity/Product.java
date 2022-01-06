package com.demo.common.domain.entity;

public record Product (
   String id,
   String description,
   boolean acceptAutomatic,
   StrategyName strategy,
   Long timeValidOffer,
   Integer minAge){
}
