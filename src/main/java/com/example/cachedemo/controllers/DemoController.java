package com.example.cachedemo.controllers;

import com.example.cachedemo.service.NumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    private final NumberService numberService;

    public DemoController(NumberService numberService) {
        this.numberService = numberService;
    }

    @GetMapping( path = "/number/square/{number}",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public String test(
            @PathVariable( value = "number", required = true ) Integer number) throws InterruptedException {
        logger.info("Received request to get square of:{}", number);
        Integer value = numberService.getValue(number);
        logger.info("Return response after getting the square of:{} is:{}", number, value);
        return String.valueOf(value);
    }

}
