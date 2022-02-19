package com.demo.cronjob.write;

import com.demo.domain.config.ConfigProperties;
import com.demo.domain.model.Person;
import com.demo.domain.service.ValidOfferProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonWriter implements ItemWriter<List<Person>> {
  private final Logger log = LoggerFactory.getLogger(PersonWriter.class);

  private final ValidOfferProductService validOfferProduct;
  private final ConfigProperties configProperties;

  public PersonWriter(
      ValidOfferProductService validOfferProduct, ConfigProperties configProperties) {
    this.validOfferProduct = validOfferProduct;
    this.configProperties = configProperties;
  }

  @Override
  public void write(final List<? extends List<Person>> personList) {
    personList.forEach(this::writePerson);
  }

  private void writePerson(List<Person> persons) {
    persons.forEach(this::executePersonProduct);
  }

  private void executePersonProduct(Person person) {
    configProperties
        .products()
        .forEach(
            product -> {
              log.info("Product {}", product);
              validOfferProduct.execute(person, product);
            });
  }
}
