package com.globant.reto.exchange.domain.error;

public class InvalidCurrencyAmountException extends RuntimeException {
  public InvalidCurrencyAmountException(String message) {
    super(message);
  }
}
