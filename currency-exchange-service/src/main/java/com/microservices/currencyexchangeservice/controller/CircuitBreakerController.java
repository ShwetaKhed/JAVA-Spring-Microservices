package com.microservices.currencyexchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@RestController
public class CircuitBreakerController {

   // private Logger logger = (Logger) LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
   // @Retry(name = "sample-api", fallbackMethod = "hardCodedResponse")
   // @CircuitBreaker(name = "default", fallbackMethod = "hardCodedResponse")
    // 10 s => 1000 calls to sample API
    @Bulkhead(name = "default")
    //@RateLimiter(name ="default")
    public String sampleApi(){
      //  logger.info("Same api ");
        System.out.println("test");
        ResponseEntity<String> forEntity =
            new RestTemplate().getForEntity("http://localhost:8000/some-dummy-url",
                    null, String.class);
        return forEntity.getBody();
    }

    public String hardCodedResponse(Exception ex){
        return "hardCoded";
    }
}
