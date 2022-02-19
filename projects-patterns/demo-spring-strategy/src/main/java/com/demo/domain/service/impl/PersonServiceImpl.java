package com.demo.domain.service.impl;

import com.demo.domain.model.Person;
import com.demo.domain.repository.PersonRepository;
import com.demo.domain.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

  @Override
  public Page<Person> find(Pageable page) {
    return personRepository.findAll(page);
  }
}
