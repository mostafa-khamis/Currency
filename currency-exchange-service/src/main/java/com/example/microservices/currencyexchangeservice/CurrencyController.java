package com.example.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/exchange")
@RestController
public class CurrencyController {
    private Logger logger = LoggerFactory.getLogger(CurrencyController.class);

    @Autowired
    private CurrencyRepo currencyRepo;
    @Autowired
    private Environment environment;


    @GetMapping("/{from}/to/{to}")
    public CurrencyExchange currencyExchange(@PathVariable String from , @PathVariable String to){
        logger.info("currencyExchange called exchange {} to {}",from,to);
        CurrencyExchange currencyExchange = currencyRepo.findByFromAndTo(from,to);
        String port = environment.getProperty("local.server.port");
        String host = environment.getProperty("HOSTNAME");
        String version = "V12";
        currencyExchange.setEnvironment(port + " " + version + " "+ host);
        return currencyExchange;
    }
    @GetMapping(name = "/say" ,value = "/say")
    public String sayHello(){
        return "Hello Mother father";
    }

}
