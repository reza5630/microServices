package com.demo.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {
    @Autowired
    ExchangeValueRepo exchangeValueRepo;


    public ExchangeValue findExchangeValueByFromAndTo(String from, String to) {
        return exchangeValueRepo.findByFromAndTo(from, to);
    }
}
