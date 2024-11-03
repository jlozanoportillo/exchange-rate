package com.globant.reto.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeRate {
  
  private Integer id;
  private String sourceCurrency;
  private String targetCurrency;
  private Double rate;
  
}
