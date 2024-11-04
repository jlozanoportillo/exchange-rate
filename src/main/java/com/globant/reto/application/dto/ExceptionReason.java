package com.globant.reto.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionReason {
  
  @JsonProperty(value = "reason")
  private String reason;
}
