package com.globant.reto.security.domain.error;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


public class UsernameNotFoundExceptionTest {

  
  @Test
  public void testExceptionMessage() {
      String errorMessage = "User not found";
 
      UsernameNotFoundException exception = assertThrows(UsernameNotFoundException.class, () -> {
          throw new UsernameNotFoundException(errorMessage);
      });
 
      assertEquals(errorMessage, exception.getMessage());
  }
  
  @Test
  public void testExceptionInheritance() {
      UsernameNotFoundException exception = new UsernameNotFoundException("Test message");
      
      // Aseguramos que la excepción es una instancia de RuntimeException
      assertEquals(RuntimeException.class, exception.getClass().getSuperclass());
  }
  
}
