package com.demo.core.domain;

import java.util.List;

public interface PersonService {

  String create(Person person);

  List<Person> find();
}
