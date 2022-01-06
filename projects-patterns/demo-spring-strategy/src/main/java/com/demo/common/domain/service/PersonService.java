package com.demo.common.domain.service;

import com.demo.common.domain.entity.Person;

import java.util.List;

public interface PersonService {

  String create(Person person);

  List<Person> find();
}
