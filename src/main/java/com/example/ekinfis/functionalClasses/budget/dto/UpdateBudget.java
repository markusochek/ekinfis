package com.example.ekinfis.functionalClasses.budget.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBudget {
    private Integer id;
    private String name;
    private Float balance;
    private Date date;
    private Integer categoryId;
}
