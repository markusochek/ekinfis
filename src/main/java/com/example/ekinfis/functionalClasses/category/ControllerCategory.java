package com.example.ekinfis.functionalClasses.category;

import com.example.ekinfis.functionalClasses.allDto.Response;
import com.example.ekinfis.functionalClasses.category.dto.AddCategory;
import com.example.ekinfis.functionalClasses.category.dto.UpdateCategory;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/categories")
public class ControllerCategory {
    private ServiceCategory serviceCategory;

    @PreAuthorize("@AccessVerification.checkToken(token)")
    @PostMapping
    public Response addCategory(@RequestHeader("authorization") String token, @RequestBody AddCategory addCategory) {
        return new Response(serviceCategory.addCategory(token, addCategory));
    }

    @PreAuthorize("@AccessVerification.checkToken(token)")
    @GetMapping
    public Response getCategories(@RequestHeader("authorization") String token) {
        return new Response(serviceCategory.getCategories());
    }

    @PreAuthorize("@AccessVerification.checkToken(token)")
    @PutMapping
    public Response updateCategory(@RequestHeader("authorization") String token, @RequestBody UpdateCategory updateCategory) {
        return new Response(serviceCategory.updateCategory(updateCategory));
    }

    @PreAuthorize("@AccessVerification.checkToken(token)")
    @DeleteMapping("/{id}")
    public Response deleteCategory(@RequestHeader("authorization") String token, @PathVariable Integer id) {
        return new Response(serviceCategory.deleteCategory(id));
    }
}
