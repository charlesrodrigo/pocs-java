package com.demo.cronjob.reader;

import com.demo.domain.config.ConfigProperties;
import com.demo.domain.model.Person;
import com.demo.domain.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class PersonOfferReader implements ItemReader<List<Person>> {
  private final Logger log = LoggerFactory.getLogger(PersonOfferReader.class);

  private final Integer pageSize;
  private final CurrentPage currentPage;
  private final PersonService personService;
  private final ConfigProperties productConfig;

  public PersonOfferReader(
      final PersonService personService, final ConfigProperties productConfig) {
    this.pageSize = 2;
    this.currentPage = new CurrentPage();
    this.personService = personService;
    this.productConfig = productConfig;
  }

  @Override
  public List<Person> read() {
    if (Objects.nonNull(productConfig)) {

      log.info("read persons");

      Pageable pageable = PageRequest.of(currentPage.getNumberCurrentPage(), pageSize);

      Page<Person> person = personService.find(pageable);

      currentPage.sumCurrentPageNumber();

      List<Person> personList = person.toList();

      log.info("return list size {}", personList.size());

      return personList.isEmpty() ? null : personList;
    }

    return null;
  }

  private static class CurrentPage {

    private int currentPageNumber;

    public CurrentPage() {
      currentPageNumber = 0;
    }

    void sumCurrentPageNumber() {
      currentPageNumber++;
    }

    int getNumberCurrentPage() {
      return currentPageNumber;
    }
  }
}
