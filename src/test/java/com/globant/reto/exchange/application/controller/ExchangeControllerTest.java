package com.globant.reto.exchange.application.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.globant.reto.exchange.application.dto.ExchangeRequest;
import com.globant.reto.exchange.application.dto.ExchangeResponse;
import com.globant.reto.exchange.application.services.ExchangeService;

import io.reactivex.Single;
import reactor.core.publisher.Mono;

public class ExchangeControllerTest {

  @InjectMocks
  private ExchangeController exchangeController;

  @Mock
  private ExchangeService exchangeService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testGetExchangeRate_Success() {
    ExchangeRequest request = new ExchangeRequest();
    request.setSourceCurrency("PEN");
    request.setTargetCurrency("USD");
    request.setAmount(100.0);

    ExchangeResponse response = new ExchangeResponse();
    response.setExchangeRate(0.85);
    response.setConvertAmount(85.0);

    when(exchangeService.exchangeCurrency(request)).thenReturn(Single.just(response));

    Mono<ResponseEntity<ExchangeResponse>> result = exchangeController
        .getExchangeRate(request);
    assertEquals(HttpStatus.OK, result.block().getStatusCode());
    assertEquals(response, result.block().getBody());
  }


}
