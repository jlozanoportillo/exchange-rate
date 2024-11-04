package com.globant.reto.exchange.domain.repository;

import com.globant.reto.exchange.domain.model.ExchangeRate;

import io.reactivex.Maybe;

public interface ExchangeRateRepository {

  public Maybe<ExchangeRate> findExchangeRate(String sourceCurrency, String targetCurrency);

}
