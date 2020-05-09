package com.demo.microservices.currencyconversionservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {
    @Autowired
    CurrencyExchangeServiceProxy exchangeProxy;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/currency-converter/from/{from}/to/{to}/value/{value}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal value){


        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("to", to);         uriVariables.put("from", from);
        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);

        CurrencyConversionBean response = responseEntity.getBody();

        return new CurrencyConversionBean(response.getId(), response.getFrom(), response.getTo(), response.getConversionRate(), response.getPort(), value, value.multiply(response.getConversionRate()));
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/value/{value}")
    public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal value){
        CurrencyConversionBean response = exchangeProxy.retrieveExchangeRate(from, to);
        logger.info("{}", response);
        return new CurrencyConversionBean(response.getId(), response.getFrom(), response.getTo(), response.getConversionRate(), response.getPort(), value, value.multiply(response.getConversionRate()));
    }
}
