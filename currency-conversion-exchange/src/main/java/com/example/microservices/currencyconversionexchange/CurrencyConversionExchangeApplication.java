package com.example.microservices.currencyconversionexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;
//@EnableEurekaServer
@EnableFeignClients
@SpringBootApplication
public class CurrencyConversionExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionExchangeApplication.class, args);
	}

}
