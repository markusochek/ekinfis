package com.example.ekinfis.functionalClasses.budget;

import com.example.ekinfis.functionalClasses.allDto.Response;
import com.example.ekinfis.functionalClasses.budget.dto.AddBudget;
import com.example.ekinfis.functionalClasses.budget.dto.UpdateBudget;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/budgets")
public class ControllerBudget {
    private ServiceBudget serviceBudget;

    @PreAuthorize("@AccessVerification.checkToken(token)")
    @PostMapping
    public Response addBudget(@RequestHeader("authorization") String token, @RequestBody AddBudget budget) {
        return new Response(serviceBudget.addBudget(token, budget));
    }

    @PreAuthorize("@AccessVerification.checkToken(token)")
    @GetMapping
    public Response getBudgetsByUser(@RequestHeader("authorization") String token) {
        return new Response(serviceBudget.getBudgets());
    }

    @PreAuthorize("@AccessVerification.checkToken(token)")
    @PutMapping
    public Response updateBudget(@RequestHeader("authorization") String token, @RequestBody UpdateBudget updateBudget) {
        return new Response(serviceBudget.updateBudget(updateBudget));
    }

    @PreAuthorize("@AccessVerification.checkToken(token)")
    @DeleteMapping("/{id}")
    public Response deleteBudget(@RequestHeader("authorization") String token, @PathVariable Integer id) {
        return new Response(serviceBudget.deleteBudget(id));
    }
}
