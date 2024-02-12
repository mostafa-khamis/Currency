package com.example.microservices.currencyconversionexchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RequestMapping("/conversion")
@RestController
public class CurrencyConversionController {
    private Logger logger =  LoggerFactory.getLogger(CurrencyConversionController.class);
    @Autowired
    public CurrencyExchangeProxy proxy;
    @GetMapping("/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion currencyConversion(@PathVariable String from , @PathVariable String to,@PathVariable BigDecimal quantity){
        logger.info("currencyConversionController called conversion {} to {} quantity {}",from,to,quantity);
        HashMap<String,String> uriVariable = new HashMap<>();
        uriVariable.put("from",from);
        uriVariable.put("to",to);
        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://currency-exchange:8000/exchange/{from}/to/{to}",CurrencyConversion.class,uriVariable);
        CurrencyConversion currencyConversion = responseEntity.getBody();
        return new CurrencyConversion(currencyConversion.getId(),from,to,quantity,currencyConversion.getConversionMultiple(),quantity.multiply(currencyConversion.getConversionMultiple()),currencyConversion.getEnvironment());
    }

    @GetMapping("/feign/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion currencyConversionFeign(@PathVariable String from , @PathVariable String to,@PathVariable BigDecimal quantity){
        logger.info("currencyConversionController called conversion feign {} to {} quantity {}",from,to,quantity);
        CurrencyConversion currencyConversion = proxy.currencyConversion(from,to);
        return new CurrencyConversion(1L,from,to,quantity,currencyConversion.getConversionMultiple(),quantity.multiply(currencyConversion.getConversionMultiple()),currencyConversion.getEnvironment());
    }
}
