package com.demo.api;

import com.demo.domain.config.ConfigProperties;
import com.demo.domain.model.Person;
import com.demo.domain.service.PersonService;
import com.demo.domain.service.StrategyService;
import com.demo.domain.service.ValidOfferProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController()
@RequestMapping("/api")
public class PersonController {
  private final Logger log = LoggerFactory.getLogger(PersonController.class);
  private final PersonService personService;
  private final ConfigProperties configProperties;
  private final ValidOfferProductService validOfferProduct;

  public PersonController(
      PersonService personService,
      ConfigProperties configProperties,
      Map<String, StrategyService> strategies,
      ValidOfferProductService validOfferProduct) {
    this.personService = personService;
    this.configProperties = configProperties;
    this.validOfferProduct = validOfferProduct;
  }

  @ResponseBody
  @PostMapping(
      value = "/person",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public String save(@RequestBody Person person) {

    var personID = personService.create(person);

    configProperties
        .products()
        .forEach(
            product -> {
              log.info("Product {}", product);
              validOfferProduct.execute(person, product);
            });

    return personID;
  }
}
