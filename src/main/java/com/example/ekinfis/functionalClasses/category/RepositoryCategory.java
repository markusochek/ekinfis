package com.example.ekinfis.functionalClasses.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryCategory extends JpaRepository<EntityCategory, Integer> {
    Optional<EntityCategory> findByName(String name);
}
