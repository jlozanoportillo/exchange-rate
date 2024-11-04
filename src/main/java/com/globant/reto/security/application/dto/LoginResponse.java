package com.globant.reto.security.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
  
  @JsonProperty(value = "token")
  private String token;
  
  
}
