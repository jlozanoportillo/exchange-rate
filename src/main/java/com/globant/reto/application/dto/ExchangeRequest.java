package com.globant.reto.application.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeRequest {
  
  @JsonProperty("amount")
  private BigDecimal amount;
  
  @JsonProperty("originCurrency")
  private String originCurrency;
  
  @JsonProperty("targetCurrency")
  private String targetCurrency;
  
}
