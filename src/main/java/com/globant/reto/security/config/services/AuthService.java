package com.globant.reto.security.config.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.reto.security.application.dto.LoginRequest;
import com.globant.reto.security.config.JwtUtil;
import com.globant.reto.security.domain.model.User;
import com.globant.reto.security.domain.repository.UserRepository;

@Service
public class AuthService {

  private final UserRepository userRepository;
  private final JwtUtil jwtUtil;

  @Autowired
  public AuthService(UserRepository userRepository, JwtUtil jwtUtil) {
    this.userRepository = userRepository;
    this.jwtUtil = jwtUtil;
  }

  public String authenticate(LoginRequest loginRequest) {
    User user = userRepository.findByUsername(loginRequest.getUsername());

    if (user == null || !user.getPassword().equals(loginRequest.getPassword())) {
      throw new RuntimeException("Invalid credentials");
    }

    return jwtUtil.generateToken(loginRequest.getUsername());

  }
}
