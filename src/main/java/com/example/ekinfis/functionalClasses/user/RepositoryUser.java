package com.example.ekinfis.functionalClasses.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryUser extends JpaRepository<EntityUser, Integer> {
    Optional<EntityUser> findByLoginAndPassword(String login, String password);
    Boolean existsByLogin(String login);
    Boolean existsByToken(String token);
    Optional<EntityUser> findByToken(String token);
}
