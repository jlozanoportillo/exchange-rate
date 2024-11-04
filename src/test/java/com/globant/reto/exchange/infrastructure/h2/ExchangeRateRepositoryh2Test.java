package com.globant.reto.exchange.infrastructure.h2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.globant.reto.exchange.domain.model.ExchangeRate;

import io.reactivex.Maybe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ExchangeRateRepositoryh2Test {
  
  @Mock
  private EntityManager entityManager;


  @InjectMocks
  private ExchangeRateRepositoryh2 exchangeRateRepositoryh2;

  
  @BeforeEach
  public void setUp() {
      MockitoAnnotations.openMocks(this);
  }
  
  @Test
  public void testFindExchangeRate_Exists() { 
    ExchangeRate mockExchangeRate = new ExchangeRate();
    mockExchangeRate.setSourceCurrency("USD");
    mockExchangeRate.setTargetCurrency("EUR");
    mockExchangeRate.setRate(0.85); 

    TypedQuery<ExchangeRate> query = mock(TypedQuery.class);
    when(entityManager.createQuery(anyString(), eq(ExchangeRate.class))).thenReturn(query);
    when(query.setParameter("sourceCurrency", "USD")).thenReturn(query);
    when(query.setParameter("targetCurrency", "EUR")).thenReturn(query);
    when(query.getSingleResult()).thenReturn(mockExchangeRate);

    // Ejecutamos el método y verificamos el resultado
    Maybe<ExchangeRate> exchangeRateMaybe = exchangeRateRepositoryh2.findExchangeRate("USD", "EUR");
    
    // Verificamos que el resultado no esté vacío y comprobamos el contenido
    exchangeRateMaybe.subscribe(exchangeRate -> {
        assertEquals("USD", exchangeRate.getSourceCurrency());
        assertEquals("EUR", exchangeRate.getTargetCurrency());
        assertEquals(0.85, exchangeRate.getRate());
    }, throwable -> {
        // Este bloque no debería ejecutarse si el resultado está presente
        throw new AssertionError("Should not have thrown an error");
    });
}
}
