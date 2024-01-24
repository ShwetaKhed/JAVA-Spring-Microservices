package com.currencyconversion.currencyconversion;

import java.math.BigDecimal;

public class CurrencyConversion {


    private long id;

    private String to;

    private String from;

    private BigDecimal conversionMultiple;

    private String environment;

    private BigDecimal totalCalculatedAmount;

    private BigDecimal quantity;

    public CurrencyConversion() {
    }

    public CurrencyConversion(long id, String to, String
            from, BigDecimal conversionMultiple, String environment,
                              BigDecimal totalCalculatedAmount, BigDecimal quantity) {
        this.id = id;
        this.to = to;
        this.from = from;
        this.conversionMultiple = conversionMultiple;
        this.environment = environment;
        this.totalCalculatedAmount = totalCalculatedAmount;
        this.quantity = quantity;
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

    public BigDecimal getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CurrencyConversion{" +
                "id=" + id +
                ", to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", conversionMultiple=" + conversionMultiple +
                ", environment='" + environment + '\'' +
                ", totalCalculatedAmount=" + totalCalculatedAmount +
                ", quantity=" + quantity +
                '}';
    }
}
