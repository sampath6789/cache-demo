package com.example.cachedemo.service;

import com.example.cachedemo.controllers.DemoController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class NumberService {

    private static final Logger logger = LoggerFactory.getLogger(NumberService.class);

    //using this annotation spring will handing caching
    //We need to provide the name of the cache to use and optionally the key.
    //We can also add a condition to restrict what is cached:
    @Cacheable(
            value = "squareCache",
            key = "#number")//,
//            condition = "#number>10")
    public Integer getValue(Integer number) {
        logger.info("getValue method started. number:{}", number);
        return number*number;
    }

}
