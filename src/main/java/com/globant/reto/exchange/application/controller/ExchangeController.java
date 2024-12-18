package com.globant.reto.exchange.application.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globant.reto.exchange.application.dto.ExchangeRequest;
import com.globant.reto.exchange.application.dto.ExchangeResponse;
import com.globant.reto.exchange.application.services.ExchangeService;

import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;
import reactor.adapter.rxjava.RxJava2Adapter;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/v1/exchange-rates")
@Slf4j
public class ExchangeController {

  @Autowired
  private ExchangeService exchangeService;

  @GetMapping(value = "/health")
  public String sayHello() {
    String[] strings = {
        "Tigre dice: FELIZ NAVIDAD!", 
        "Tigre dice: MERRY CHRISTMAS!", 
        "Tigre dice: Buon Natale!", 
        "Tigre dice: Feliz Natal!", 
        "Tigre dice: Happy New Year!",
        "Tigre dice: Buon anno!",
        "Tigre dice: Feliz Año!"};
    Random random = new Random();
    int randomIndex = random.nextInt(strings.length);
    String elegido =strings[randomIndex];
    return "<br><br><h1 style=\"text-align: center; white-space: nowrap; animation: move 3s linear infinite;\">"+elegido+"</h1>";
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<ExchangeResponse>> getExchangeRate(
      @RequestBody ExchangeRequest request) {
    log.info("into getExchangeRate.");
    Single<ExchangeResponse> singleResponse = exchangeService.exchangeCurrency(request);
    return RxJava2Adapter.singleToMono(singleResponse)
        .map(ResponseEntity::ok)
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

}
