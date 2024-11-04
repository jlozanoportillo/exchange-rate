package com.globant.reto.security.application.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginRequestTest {

  @Test
  public void testGettersAndSetters() { 
      LoginRequest loginRequest = new LoginRequest();

      // Establecer valores
      String username = "testUser";
      String password = "testPassword";
      loginRequest.setUsername(username);
      loginRequest.setPassword(password);
 
      assertEquals(username, loginRequest.getUsername());
      assertEquals(password, loginRequest.getPassword());
  }

  @Test
  public void testDefaultConstructor() { 
      LoginRequest loginRequest = new LoginRequest();
      
      // Comprobar que los valores por defecto son null
      assertEquals(null, loginRequest.getUsername());
      assertEquals(null, loginRequest.getPassword());
  }
}
