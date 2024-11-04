package com.globant.reto.infrastructure.h2;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.globant.reto.domain.model.ExchangeRate;
import com.globant.reto.domain.repository.ExchangeRateRepository;

import io.reactivex.Maybe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

@Repository
public class ExchangeRateRepositoryh2 implements ExchangeRateRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  public Maybe<ExchangeRate> findExchangeRate(String sourceCurrency,
      String targetCurrency) {
    String query = "SELECT e FROM ExchangeRate e WHERE e.sourceCurrency = :sourceCurrency AND e.targetCurrency = :targetCurrency";
    try {
      ExchangeRate ex = entityManager.createQuery(query, ExchangeRate.class)
          .setParameter("sourceCurrency", sourceCurrency)
          .setParameter("targetCurrency", targetCurrency)
          .getSingleResult();
      return Maybe.just(ex);
    } catch (NoResultException e) {
      return Maybe.empty();
    }
  }

}
