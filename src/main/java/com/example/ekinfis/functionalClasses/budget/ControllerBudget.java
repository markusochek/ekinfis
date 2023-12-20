package com.example.ekinfis.functionalClasses.budget;

import com.example.ekinfis.functionalClasses.budget.dto.AddBudget;
import com.example.ekinfis.functionalClasses.budget.dto.UpdateBudget;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.header.Header;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

import java.util.Collection;

import static org.springframework.http.ResponseEntity.ok;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/budgets")
public class ControllerBudget {
    private ServiceBudget serviceBudget;

    @PreAuthorize("@AccessVerification.checkToken(token)")
    @PostMapping
    public ResponseEntity<Integer> addBudget(@RequestHeader("authorization") String token, @RequestBody AddBudget budget) {
        return ok(serviceBudget.addBudget(token, budget));
    }

    @PreAuthorize("@AccessVerification.checkToken(token)")
    @GetMapping
    public ResponseEntity<Collection<EntityBudget>> getBudgetsByUser(@RequestHeader("authorization") String token) {
        return ok(serviceBudget.getBudgets());
    }

    @PreAuthorize("@AccessVerification.checkToken(token)")
    @PutMapping
    public ResponseEntity<Boolean> updateBudget(@RequestHeader("authorization") String token, @RequestBody UpdateBudget updateBudget) {
        return ok(serviceBudget.updateBudget(updateBudget));
    }

    @PreAuthorize("@AccessVerification.checkToken(token)")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteBudget(@RequestHeader("authorization") String token, @PathVariable Integer id) {
        return ok(serviceBudget.deleteBudget(id));
    }
}
