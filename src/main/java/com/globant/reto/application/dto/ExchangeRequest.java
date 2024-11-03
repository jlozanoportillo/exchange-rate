package com.globant.reto.application.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeRequest {
  
  private BigDecimal amount;
  
  private String originCurrency;
  
  private String targetCurrency;
  
}
