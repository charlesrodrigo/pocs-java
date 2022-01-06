package com.demo.api;

import com.demo.common.config.ConfigProperties;
import com.demo.common.domain.entity.Person;
import com.demo.common.domain.service.PersonService;
import com.demo.common.domain.service.StrategyService;
import com.demo.common.domain.service.ValidOfferProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class RequestController {
  private final Logger log = LoggerFactory.getLogger(RequestController.class);
  private final PersonService personService;
  private final Optional<ConfigProperties> configProperties;
  private final ValidOfferProductService validOfferProduct;

  public RequestController(
      PersonService personService,
      Optional<ConfigProperties> configProperties,
      Map<String, StrategyService> strategies,
      ValidOfferProductService validOfferProduct) {
    this.personService = personService;
    this.configProperties = configProperties;
    this.validOfferProduct = validOfferProduct;
  }

  @ResponseBody
  @PostMapping(
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public String save(@RequestBody Person person) {

    configProperties
        .get()
        .products()
        .forEach(
            product -> {
              log.info("Product {}", product);
              validOfferProduct.execute(person, product);
            });

    return personService.create(person);
  }
}
