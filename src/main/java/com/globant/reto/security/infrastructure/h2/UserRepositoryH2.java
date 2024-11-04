package com.globant.reto.security.infrastructure.h2;

import org.springframework.stereotype.Repository;

import com.globant.reto.security.domain.model.User;
import com.globant.reto.security.domain.repository.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

@Repository
public class UserRepositoryH2 implements UserRepository{

  @PersistenceContext
  private EntityManager entityManager;

  public User findByUsername(String username) {
    String query = "SELECT e FROM User e WHERE e.username = :username";
    try {
      User ex = entityManager
          .createQuery(query, User.class)
          .setParameter("username", username)
          .getSingleResult();
      return ex;
    } catch (NoResultException e) {
      return null;
    }
  }

}
