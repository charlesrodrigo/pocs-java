package com.demo.domain.service;

import com.demo.domain.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {

  String create(Person person);

  List<Person> find();

  Page<Person> find(Pageable page);
}
