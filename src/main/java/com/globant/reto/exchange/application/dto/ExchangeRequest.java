package com.globant.reto.exchange.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeRequest {
  
  @JsonProperty("amount")
  private Double amount;
  
  @JsonProperty("sourceCurrency")
  private String sourceCurrency;
  
  @JsonProperty("targetCurrency")
  private String targetCurrency;
  
}
