package com.example.ekinfis.functionalClasses.category;

import com.example.ekinfis.functionalClasses.category.dto.AddCategory;
import com.example.ekinfis.functionalClasses.category.dto.UpdateCategory;
import com.example.ekinfis.functionalClasses.user.EntityUser;
import com.example.ekinfis.functionalClasses.user.RepositoryUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceCategory {
    RepositoryCategory repositoryCategory;
    RepositoryUser repositoryUser;

    public Integer addCategory(String token, AddCategory addCategory) {
        System.out.println(token);
        EntityUser entityUser = repositoryUser.findByToken(token).orElseThrow(() -> new RuntimeException("Could not find user"));
        Optional<EntityCategory> entityCategory = repositoryCategory.findByName(addCategory.getName());
        if (entityCategory.isPresent()) {
            return entityCategory.get().getId();
        }
        return repositoryCategory.save(new EntityCategory(addCategory, entityUser)).getId();
    }

    public Collection<EntityCategory> getCategories() {
        return repositoryCategory.findAll();
    }

    public Boolean updateCategory(UpdateCategory updateCategory) {
        EntityCategory entityCategoryDB = repositoryCategory.findById(updateCategory.getId()).orElseThrow(() -> new RuntimeException("Could not find category"));
        entityCategoryDB.setAll(updateCategory);
        repositoryCategory.save(entityCategoryDB);
        return true;
    }

    public Boolean deleteCategory(Integer id) {
        repositoryCategory.deleteById(id);
        return true;
    }
}
