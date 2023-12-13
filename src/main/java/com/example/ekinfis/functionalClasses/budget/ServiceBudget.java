package com.example.ekinfis.functionalClasses.budget;

import com.example.ekinfis.functionalClasses.budget.dto.AddBudget;
import com.example.ekinfis.functionalClasses.budget.dto.UpdateBudget;
import com.example.ekinfis.functionalClasses.category.EntityCategory;
import com.example.ekinfis.functionalClasses.category.RepositoryCategory;
import com.example.ekinfis.functionalClasses.user.EntityUser;
import com.example.ekinfis.functionalClasses.user.RepositoryUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ServiceBudget {
    RepositoryBudget repositoryBudget;
    RepositoryCategory repositoryCategory;
    RepositoryUser repositoryUser;
    public Collection<EntityBudget> getBudgets() {
        return repositoryBudget.findAll();
    }

    public Integer addBudget(String token, AddBudget addBudget) {
        EntityCategory entityCategory = repositoryCategory.findById(addBudget.getCategoryEntityId()).orElseThrow(() -> new RuntimeException("Could not find category"));
        EntityUser entityUser = repositoryUser.findByToken(token).orElseThrow(() -> new RuntimeException("Could not find user"));
        return repositoryBudget.save(new EntityBudget(addBudget, entityCategory, entityUser)).getId();
    }

    public Boolean updateBudget(UpdateBudget updateBudget) {
        EntityBudget entityBudgetDB = repositoryBudget.findById(updateBudget.getId()).orElseThrow(() -> new RuntimeException("Could not find budget"));
        EntityCategory entityCategory = repositoryCategory.findById(updateBudget.getCategoryEntityId()).orElseThrow(() -> new RuntimeException("Could not find category"));
        entityBudgetDB.setAll(updateBudget, entityCategory);
        repositoryBudget.save(entityBudgetDB);
        return true;
    }

    public Boolean deleteBudget(Integer id) {
        repositoryBudget.deleteById(id);
        return true;
    }
}
