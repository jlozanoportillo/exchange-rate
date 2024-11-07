package com.globant.reto.exchange.infrastructure.h2;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.globant.reto.exchange.application.dto.ExchangeRequest;
import com.globant.reto.exchange.domain.model.Coupon;
import com.globant.reto.exchange.domain.model.ExchangeRate;
import com.globant.reto.exchange.domain.repository.ExchangeRateRepository;

import io.reactivex.Maybe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

@Repository
public class ExchangeRateRepositoryh2 implements ExchangeRateRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
//  @Cacheable(value = "exchangeRates", key = "#sourceCurrency + '-' + #targetCurrency", cacheManager = "cacheManager")
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
  
  
  
  public Maybe<Coupon>  findCoupon(String keyCoupon, ExchangeRequest request){
    Coupon coupon = new Coupon();
    coupon.setRateAdittional(0.0d);
    if(keyCoupon.equals("123")) {
      coupon.setRateAdittional(2d);
      return Maybe.just(coupon);
    }
    return Maybe.empty();
  }

}
