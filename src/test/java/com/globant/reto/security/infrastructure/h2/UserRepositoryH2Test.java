package com.globant.reto.security.infrastructure.h2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.globant.reto.security.domain.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class UserRepositoryH2Test {

  @Mock
  private EntityManager entityManager;

  @InjectMocks
  private UserRepositoryH2 userRepositoryH2;

  @BeforeEach
  public void setUp() {
      MockitoAnnotations.openMocks(this);
  }
  
  @Test
  public void testFindByUsername_UserExists() {
    User mockUser = new User();
    mockUser.setUsername("testuser");
    
    TypedQuery<User> query = mock(TypedQuery.class);

    when(entityManager.createQuery(anyString(), eq(User.class))).thenReturn(query);
    when(query.setParameter(eq("username"), eq("testuser"))).thenReturn(query);
    when(query.getSingleResult()).thenReturn(mockUser);
    
    User user = userRepositoryH2.findByUsername("testuser");
    assertEquals("testuser", user.getUsername());
  }
  
  @Test
  public void testFindByUsername_UserDoesNotExist() { 
      TypedQuery<User> query = mock(TypedQuery.class);
      when(entityManager.createQuery(anyString(), eq(User.class))).thenReturn(query);
      when(query.setParameter("username", "nonexistentuser")).thenReturn(query);
      when(query.getSingleResult()).thenThrow(new NoResultException());
 
      User user = userRepositoryH2.findByUsername("nonexistentuser");
      assertNull(user);
  }
  
}
