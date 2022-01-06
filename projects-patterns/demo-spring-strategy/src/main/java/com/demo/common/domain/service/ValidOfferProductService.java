package com.demo.common.domain.service;

import com.demo.common.domain.entity.Person;
import com.demo.common.domain.entity.Product;

public interface ValidOfferProductService {

  void execute(Person person, Product product);
}
