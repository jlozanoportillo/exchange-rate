package com.globant.reto.application.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExchangeResponse {

  @JsonProperty("initialAmount")
  private BigDecimal initialAmount;
  
  @JsonProperty("convertAmount")
  private BigDecimal convertAmount;
  
  @JsonProperty("souceCurrency")
  private String souceCurrency;

  @JsonProperty("targetCurrency")
  private String targetCurrency;
  
  @JsonProperty("exchangeRate")
  private BigDecimal exchangeRate;
  
  public ExchangeResponse() {
  }

}
