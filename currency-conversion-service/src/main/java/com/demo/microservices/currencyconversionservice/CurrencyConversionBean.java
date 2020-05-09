package com.demo.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversionBean {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionRate;
    private int port;
    private BigDecimal value;
    private BigDecimal totalAmount;

    public CurrencyConversionBean(Long id, String from, String to, BigDecimal conversionRate, int port, BigDecimal value, BigDecimal totalAmount) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionRate = conversionRate;
        this.port = port;
        this.value = value;
        this.totalAmount = totalAmount;
    }

    public CurrencyConversionBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
