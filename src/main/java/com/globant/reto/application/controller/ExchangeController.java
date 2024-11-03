package com.globant.reto.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globant.reto.application.dto.ExchangeRequest;
import com.globant.reto.application.dto.ExchangeResponse;
import com.globant.reto.application.services.ExchangeService;

import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;
import reactor.adapter.rxjava.RxJava2Adapter;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("exchange")
@Slf4j
public class ExchangeController {

  @Autowired
  private ExchangeService exchangeService;

  @GetMapping(value = "/health")
  public String sayHello() {
    return "I am Live";
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<ExchangeResponse>> getExchangeMessage(
      @RequestBody ExchangeRequest request) {
    log.info("into getExchangeMessage. "+request.getOriginCurrency());
    Single<ExchangeResponse> singleResponse = exchangeService.exchangeCurrency(request);
    return RxJava2Adapter.singleToMono(singleResponse)
        .map(ResponseEntity::ok)
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

}
