package com.example.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepo extends JpaRepository<CurrencyExchange,Long> {
    CurrencyExchange findByFromAndTo(String from , String to);
}
