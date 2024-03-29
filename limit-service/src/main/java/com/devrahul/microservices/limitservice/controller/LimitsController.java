package com.devrahul.microservices.limitservice.controller;

import com.devrahul.microservices.limitservice.configuration.Configuration;
import com.devrahul.microservices.limitservice.entity.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public Limits limitsRetrieve(){
        return new Limits(configuration.getMinimum(),configuration.getMaximum());
       // return new Limits(1,1000);
    }
}
