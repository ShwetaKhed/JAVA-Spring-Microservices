package com.study.rest.webservices.restfulwebservices;

import com.study.rest.webservices.restfulwebservices.helloWorld.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Currency;
import java.util.Locale;

// Rest API
@RestController
public class CurrencyController {

    @Autowired
    private CurrencyServiceConfiguration currencyServiceConfiguration;

    @RequestMapping("/currency-configuration")
   public CurrencyServiceConfiguration retrieve(){
       return currencyServiceConfiguration;
   }
}
