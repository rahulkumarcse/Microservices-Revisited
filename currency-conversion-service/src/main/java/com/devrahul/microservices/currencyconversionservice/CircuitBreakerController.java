package com.devrahul.microservices.currencyconversionservice;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {
    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
    @GetMapping("/sample-api")
//    @Retry(name = "sample-api",fallbackMethod = "defaultRetryMethod")
//    @CircuitBreaker(name = "sample-api",fallbackMethod = "defaultRetryMethod")
//    @RateLimiter(name = "default")
    @Bulkhead(name = "default")
    public String sampleApi(){
//        logger.info("Sample Api Call");
//        ResponseEntity<String> responseEntity= new RestTemplate().getForEntity("http://localhost:8080/dummy-url",String.class);
//        return responseEntity.getBody();
        return "sample-api";
    }

    public String defaultRetryMethod(Exception ex){
        return "Fallbackmethod";
    }
}

