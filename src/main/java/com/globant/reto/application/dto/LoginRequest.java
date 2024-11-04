package com.globant.reto.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {
  
  @JsonProperty(value = "username")
  private String username;
  
  @JsonProperty(value = "password")
  private String password;
  
  public LoginRequest() {}
}
