package com.microservices.currencyexchangeservice.controller;


import com.microservices.currencyexchangeservice.CurrencyExchange;
import com.microservices.currencyexchangeservice.CurrencyExchangeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;


    @Autowired
    private CurrencyExchangeRepo currencyExchangeRepo;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to)
    {
       // CurrencyExchange currencyExchange =
         //       new CurrencyExchange(1000, to, from, BigDecimal.valueOf(50));
        //currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        CurrencyExchange currencyExchange = currencyExchangeRepo.findByFromAndTo(from, to);

        if (currencyExchange == null)
        {
            throw new RuntimeException("Unable to find" + from + " and " + to);
        }
        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }


}
