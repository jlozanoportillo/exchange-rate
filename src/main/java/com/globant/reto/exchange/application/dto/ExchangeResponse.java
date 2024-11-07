package com.globant.reto.exchange.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExchangeResponse {

  @JsonProperty("initialAmount")
  private Double initialAmount;
  
  @JsonProperty("convertAmount")
  private Double convertAmount;
  
  @JsonProperty("souceCurrency")
  private String souceCurrency;

  @JsonProperty("targetCurrency")
  private String targetCurrency;
  
  @JsonProperty("exchangeRate")
  private Double exchangeRate;

  @JsonProperty("additionalRate")
  private Double additionalRate;
  
  
  public ExchangeResponse() {
  }

}
