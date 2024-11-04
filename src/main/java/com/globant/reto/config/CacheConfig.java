package com.globant.reto.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

@Configuration
public class CacheConfig {

  @Bean
  public CacheManager cacheManager() {
    CaffeineCacheManager cacheManager = new CaffeineCacheManager("exchangeRates");
    cacheManager.setCaffeine(
        Caffeine
        .newBuilder()
        .expireAfterWrite(5, TimeUnit.MINUTES)
        .maximumSize(100)
        );
    return cacheManager;
  }
}
