package com.globant.reto.application.controller;

import org.springframework.boot.ApplicationArguments;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.reactivex.Single;
import reactor.adapter.rxjava.RxJava2Adapter;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("exchange")
public class ExchangeController {

  @GetMapping(value = "/health")
  public String sayHello() {
    return "I am Live";
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<String>> getExchangeMessage() {
    Single<String> singleMessage = Single.just("Hello from RxJava2!");
    return RxJava2Adapter.singleToMono(singleMessage).map(ResponseEntity::ok);
  }

}
