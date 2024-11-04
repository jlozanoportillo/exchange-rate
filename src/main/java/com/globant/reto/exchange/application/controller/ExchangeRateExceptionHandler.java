package com.globant.reto.exchange.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.globant.reto.exchange.application.dto.ExceptionReason;
import com.globant.reto.exchange.domain.error.ExchangeRateNotFoundException;
import com.globant.reto.exchange.domain.error.InvalidCurrencyAmountException;

@ControllerAdvice
public class ExchangeRateExceptionHandler {

  @ExceptionHandler(ExchangeRateNotFoundException.class)
  public ResponseEntity<ExceptionReason> handleExchangeRateNotFoundException(
      ExchangeRateNotFoundException ex) {
    ExceptionReason s = new ExceptionReason();
    s.setReason(ex.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(s);
  }

  @ExceptionHandler(InvalidCurrencyAmountException.class)
  public ResponseEntity<ExceptionReason> handleInvalidCurrencyAmount(
      InvalidCurrencyAmountException ex) {
    ExceptionReason s = new ExceptionReason();
    s.setReason(ex.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(s);
  }

}
