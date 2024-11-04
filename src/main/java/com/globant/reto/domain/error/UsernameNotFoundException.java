package com.globant.reto.domain.error;

public class UsernameNotFoundException extends RuntimeException {
  
  private static final long serialVersionUID = 1L;

  public UsernameNotFoundException(String message) {
    super(message);
  }
}
