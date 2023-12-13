package com.example.ekinfis.functionalClasses.budget.dto;

import com.example.ekinfis.functionalClasses.category.EntityCategory;
import com.example.ekinfis.functionalClasses.user.EntityUser;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddBudget {
    private String name;
    private Float balance;
    private Integer categoryEntityId;
}
