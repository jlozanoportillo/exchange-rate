package com.globant.reto.application.services;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.globant.reto.application.dto.ExchangeRequest;
import com.globant.reto.application.dto.ExchangeResponse;

import io.reactivex.Single;

@Service
@Slf4j
public class ExchangeService {

  public Single<ExchangeResponse> exchangeCurrency(ExchangeRequest request) {
    log.info("into exchangeCurrency222.");
    Single<ExchangeResponse> singleMessage = Single.just(new ExchangeResponse());
    return singleMessage;
  }
}
