package com.globant.reto.exchange.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.reto.exchange.application.dto.ExchangeRequest;
import com.globant.reto.exchange.application.dto.ExchangeResponse;
import com.globant.reto.exchange.domain.error.ExchangeRateNotFoundException;
import com.globant.reto.exchange.domain.error.InvalidCurrencyAmountException;
import com.globant.reto.exchange.domain.model.Coupon;
import com.globant.reto.exchange.domain.model.ExchangeRate;
import com.globant.reto.exchange.domain.repository.ExchangeRateRepository;

import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExchangeService {

  @Autowired
  private ExchangeRateRepository exchangeRateRepository;

  public Single<ExchangeResponse> exchangeCurrency(ExchangeRequest request) {
    log.info("into exchangeCurrency.");
    Maybe<Coupon> coupon = exchangeRateRepository.findCoupon(request.getCouponKey(),
        request);
    return Single.just(request).flatMap(req -> {

      if (req.getAmount() == null || req.getAmount() <= 0) {
        return Single.error(new InvalidCurrencyAmountException("Initial Amount invalid"));
      }
      return obtainRate(request)
          .subscribeOn(Schedulers.io())
          .switchIfEmpty(Maybe.error(
              new ExchangeRateNotFoundException("No exchange rate found for currencies: "
                  + request.getSourceCurrency() + " to " + request.getTargetCurrency())))
          .flatMap(resp -> {
            return coupon.map(coup -> clone(resp, coup)).switchIfEmpty(Maybe.just(resp));
          })
          .map(res -> prepareResponse(res, request)).toSingle();
    });

  }

  public Maybe<ExchangeRate> obtainRate(ExchangeRequest request) {
    return exchangeRateRepository.findExchangeRate(request.getSourceCurrency(),
        request.getTargetCurrency());
  }

  private ExchangeResponse prepareResponse(ExchangeRate i, ExchangeRequest request) {
    ExchangeResponse response = new ExchangeResponse();
    Double convertAmount = request.getAmount() * i.getRate();

    response.setSouceCurrency(i.getSourceCurrency());
    response.setTargetCurrency(i.getTargetCurrency());
    response.setExchangeRate(i.getRate());
    response.setInitialAmount(request.getAmount());
    response.setConvertAmount(convertAmount);
    return response;
  }

  public ExchangeRate clone(ExchangeRate rate, Coupon coupon) {
    ExchangeRate ex = new ExchangeRate();
    ex.setRate(rate.getRate() + coupon.getRateAdittional());
    ex.setSourceCurrency(rate.getSourceCurrency());
    ex.setTargetCurrency(rate.getTargetCurrency());

    return ex;
  }
}
