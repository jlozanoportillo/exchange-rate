package com.globant.reto.application.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.reto.application.dto.ExchangeRequest;
import com.globant.reto.application.dto.ExchangeResponse;
import com.globant.reto.domain.model.ExchangeRate;
import com.globant.reto.domain.repository.ExchangeRateRepository;

import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExchangeService {

  @Autowired
  private ExchangeRateRepository exchangeRateRepository;

  public Single<ExchangeResponse> exchangeCurrency(ExchangeRequest request) {
    log.info("into exchangeCurrency.");
    Maybe<ExchangeRate> singleMessage = exchangeRateRepository
        .findExchangeRate(request.getSourceCurrency(), request.getTargetCurrency());

    return singleMessage.subscribeOn(Schedulers.io())

        .map(i -> {
          ExchangeResponse response = new ExchangeResponse();
          response.setSouceCurrency(i.getSourceCurrency());
          response.setTargetCurrency(i.getTargetCurrency());
          BigDecimal s = new BigDecimal(i.getRate());
          response.setExchangeRate(s);
          response.setInitialAmount(request.getAmount());
          response.setConvertAmount(
              new BigDecimal(request.getAmount().floatValue() * i.getRate()));
          return response;
        })
        .switchIfEmpty(Maybe.just(new ExchangeResponse()))
        .toSingle();
  }

}
