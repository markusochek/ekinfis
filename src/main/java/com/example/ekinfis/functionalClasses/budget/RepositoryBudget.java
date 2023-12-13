package com.example.ekinfis.functionalClasses.budget;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBudget extends JpaRepository<EntityBudget, Integer> {
}
