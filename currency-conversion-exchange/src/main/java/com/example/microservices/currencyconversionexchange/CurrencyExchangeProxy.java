package com.example.microservices.currencyconversionexchange;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange",url = "localhost:8000")
@FeignClient(name = "currency-exchange", url = "${CURRENCY_EXCHANGE_URI:http://localhost}:8000")

//@FeignClient(name = "currency-exchange", url = "${CURRENCY_EXCHANGE_SERVICE_HOST:http://localhost}:8000")
public interface CurrencyExchangeProxy {
    @GetMapping("/exchange/{from}/to/{to}")
    public CurrencyConversion currencyConversion(@PathVariable String from , @PathVariable String to);
}
