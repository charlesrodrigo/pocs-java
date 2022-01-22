package com.app.archunitexamples.api;

import com.app.archunitexamples.domain.service.impl.AppServiceImpl;
import org.springframework.stereotype.Controller;

@Controller
public class HelloWorldController {

    private final AppServiceImpl appService;


    public HelloWorldController(AppServiceImpl appService) {
        this.appService = appService;
    }
}
