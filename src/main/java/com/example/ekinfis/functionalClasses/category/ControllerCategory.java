package com.example.ekinfis.functionalClasses.category;

import com.example.ekinfis.functionalClasses.budget.EntityBudget;
import com.example.ekinfis.functionalClasses.budget.ServiceBudget;
import com.example.ekinfis.functionalClasses.category.dto.AddCategory;
import com.example.ekinfis.functionalClasses.category.dto.UpdateCategory;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.http.ResponseEntity.ok;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/categories")
public class ControllerCategory {
    private ServiceCategory serviceCategory;

    @PreAuthorize("@AccessVerification.checkToken(token)")
    @PostMapping
    public ResponseEntity<Integer> addCategory(@RequestHeader("authorization") String token, @RequestBody AddCategory addCategory) {
        return ok(serviceCategory.addCategory(token, addCategory));
    }

    @PreAuthorize("@AccessVerification.checkToken(token)")
    @GetMapping
    public ResponseEntity<Collection<EntityCategory>> getCategories(@RequestHeader("authorization") String token) {
        return ok(serviceCategory.getCategories());
    }

    @PreAuthorize("@AccessVerification.checkToken(token)")
    @PutMapping
    public ResponseEntity<Boolean> updateCategory(@RequestHeader("authorization") String token, @RequestBody UpdateCategory updateCategory) {
        return ok(serviceCategory.updateCategory(updateCategory));
    }

    @PreAuthorize("@AccessVerification.checkToken(token)")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCategory(@RequestHeader("authorization") String token, @PathVariable Integer id) {
        return ok(serviceCategory.deleteCategory(id));
    }
}
