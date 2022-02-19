package com.demo.domain.service;

import com.demo.domain.model.Person;
import com.demo.domain.model.Product;

public interface ValidOfferProductService {

  void execute(Person person, Product product);
}
