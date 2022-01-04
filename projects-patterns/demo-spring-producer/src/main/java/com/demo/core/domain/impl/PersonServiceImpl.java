package com.demo.core.domain.impl;

import com.demo.core.domain.Person;
import com.demo.core.domain.PersonRepository;
import com.demo.core.domain.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

  private final PersonRepository personRepository;

  public PersonServiceImpl(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public String create(Person person) {

    var personNew = this.personRepository.save(person);

    return personNew.getId();
  }

  @Override
  public List<Person> find() {
    return personRepository.findAll();
  }
}
