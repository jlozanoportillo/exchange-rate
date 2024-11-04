package com.globant.reto.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globant.reto.application.dto.LoginRequest;
import com.globant.reto.application.dto.LoginResponse;
import com.globant.reto.application.services.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  private AuthService authService;

  
  @GetMapping(value = "/health")
  public String sayHello() {
    return "I am Live";
  }
  
  
  
  @PostMapping("/login")
  public ResponseEntity<LoginResponse> authenticateUser(
      @RequestBody LoginRequest loginRequest) {
    String token = authService.authenticate(loginRequest);

    // Devuelve el token en la respuesta
    return ResponseEntity.ok(new LoginResponse(token));
  }
}
