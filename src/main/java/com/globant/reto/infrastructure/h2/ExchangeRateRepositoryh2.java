package com.globant.reto.infrastructure.h2;

import org.springframework.stereotype.Repository;

import com.globant.reto.domain.model.ExchangeRate;
import com.globant.reto.domain.repository.ExchangeRateRepository;

@Repository
public class ExchangeRateRepositoryh2 implements ExchangeRateRepository{

  @Override
  public ExchangeRate findExchangeRate(String sourceCurrency, String targetCurrency) {
    ExchangeRate  exchangeRate = new ExchangeRate();
    exchangeRate.setId(1);
    exchangeRate.setSourceCurrency("PEN");
    exchangeRate.setTargetCurrency("USD");
    exchangeRate.setRate(0.3);
    return exchangeRate;
  }

}
