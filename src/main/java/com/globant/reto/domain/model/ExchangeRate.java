package com.globant.reto.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "EXCHANGE_RATE")
public class ExchangeRate {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @Column(name = "source_currency", nullable = false, length = 3)
  private String sourceCurrency;
  
  @Column(name = "target_currency", nullable = false, length = 3)
  private String targetCurrency;
  
  @Column(name = "rate", nullable = false)
  private Double rate;
  
}
