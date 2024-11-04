package com.globant.reto.security.domain.repository;

import com.globant.reto.domain.model.User;

public interface UserRepository {
  
  public User findByUsername(String username);
  
}
