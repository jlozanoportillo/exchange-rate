package com.globant.reto.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.globant.reto.application.dto.ExceptionReason;
import com.globant.reto.domain.error.ExchangeRateNotFoundException;
import com.globant.reto.domain.error.InvalidCurrencyAmountException;

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
