package com.example.ekinfis.functionalClasses.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCategory extends JpaRepository<EntityCategory, Integer> {
}
