package com.demo.common.domain.service.impl;

import com.demo.common.domain.entity.Person;
import com.demo.common.domain.repo.PersonRepository;
import com.demo.common.domain.service.PersonService;
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
