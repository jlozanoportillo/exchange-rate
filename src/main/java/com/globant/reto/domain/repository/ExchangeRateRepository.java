package com.globant.reto.domain.repository;

import com.globant.reto.domain.model.ExchangeRate;

public interface ExchangeRateRepository {

  public ExchangeRate findExchangeRate(String sourceCurrency, String targetCurrency);

}
