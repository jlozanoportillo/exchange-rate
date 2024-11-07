package com.globant.reto.exchange.domain.model;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coupon {

  private String key;
  private String sourceCurrency;

  private String targetCurrency;

  private Double rateAdittional;
}
