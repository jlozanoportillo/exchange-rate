package com.globant.reto.domain.repository;

import com.globant.reto.domain.model.ExchangeRate;

import io.reactivex.Maybe;

public interface ExchangeRateRepository {

  public Maybe<ExchangeRate> findExchangeRate(String sourceCurrency, String targetCurrency);

}
