package com.example.microservices.currencyexchangeservice;

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
    @Retry(name = "sample-api",fallbackMethod = "lol")
    public String sampleApi(){
        logger.info("loooooooooooooooooooooooooooooooooool");
        ResponseEntity<String> entity = new RestTemplate().getForEntity("localhost:8080",String.class);
        return entity.getBody();
    }
    public String lol(Exception ex){
        return "loooooooooooooool";
    }
}