package com.microservices.currencyexchangeservice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class CurrencyExchange {

    @Id
    private long id;

    @Column(name = "currency_to")
    private String to;
    @Column(name = "currency_from")
    private String from;

    private BigDecimal conversionMultiple;

    private String environment;

    public CurrencyExchange() {
    }

    public CurrencyExchange(long id, String to, String from, BigDecimal conversionMultiple) {
        this.id = id;
        this.to = to;
        this.from = from;
        this.conversionMultiple = conversionMultiple;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }


}
