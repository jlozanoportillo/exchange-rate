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
        .map(i -> prepareResponse(i, request))
        .switchIfEmpty(Maybe.just(new ExchangeResponse())).toSingle();
  }

  private ExchangeResponse prepareResponse(ExchangeRate i, ExchangeRequest request) {
    ExchangeResponse response = new ExchangeResponse();
    BigDecimal rate = new BigDecimal(i.getRate());
    BigDecimal convertAmount = new BigDecimal(request.getAmount().floatValue() * i.getRate());
    
    response.setSouceCurrency(i.getSourceCurrency());
    response.setTargetCurrency(i.getTargetCurrency());
    response.setExchangeRate(rate);
    response.setInitialAmount(request.getAmount());
    response.setConvertAmount(convertAmount);
    return response;
  }
}
