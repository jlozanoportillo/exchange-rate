package com.globant.reto.exchange.domain.repository;

import com.globant.reto.exchange.application.dto.ExchangeRequest;
import com.globant.reto.exchange.domain.model.Coupon;
import com.globant.reto.exchange.domain.model.ExchangeRate;

import io.reactivex.Maybe;

public interface ExchangeRateRepository {

  public Maybe<ExchangeRate> findExchangeRate(String sourceCurrency, String targetCurrency);
  public Maybe<Coupon>  findCoupon(String keyCoupon, ExchangeRequest request);
}
