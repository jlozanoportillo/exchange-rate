package com.globant.reto.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("exchange")
public class ExchangeController {
  
  @GetMapping(value = "/health")
  public String sayHello() {
    return "I am Live";
  }
  
}
