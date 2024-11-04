package com.globant.reto.domain.error;

public class InvalidCurrencyAmountException extends RuntimeException {
  public InvalidCurrencyAmountException(String message) {
    super(message);
  }
}
