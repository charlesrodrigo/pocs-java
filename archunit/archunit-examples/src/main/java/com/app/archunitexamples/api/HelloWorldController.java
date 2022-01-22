package com.app.archunitexamples.api;

import com.app.archunitexamples.domain.service.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloWorldController {

    private final AppService appService;

    // private final Logger log = Logger.getLogger(HelloWorldController.class.getName());

    private final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);


    public HelloWorldController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/")
    public String hello() {
        //NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS
        //exception throw new RuntimeException("aa");

//  NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS
//        try {
//            throw new NumberFormatException();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //System.out.println("hello");
//        System.err.println("hello");

        logger.info("hello !");

        return "hello";
    }
}
