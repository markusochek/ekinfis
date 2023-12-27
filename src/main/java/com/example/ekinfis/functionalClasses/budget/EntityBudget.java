package com.example.ekinfis.functionalClasses.budget;

import com.example.ekinfis.functionalClasses.budget.dto.AddBudget;
import com.example.ekinfis.functionalClasses.budget.dto.UpdateBudget;
import com.example.ekinfis.functionalClasses.category.EntityCategory;
import com.example.ekinfis.functionalClasses.user.EntityUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "budgets")
public class EntityBudget {
    @Id
    @SequenceGenerator(name="budgets_sequence",sequenceName="budgets_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "budgets_sequence")
    private Integer id;
    private String name;
    private Float balance;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private EntityCategory entityCategory;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private EntityUser entityUser;

    public EntityBudget(AddBudget addBudget, EntityCategory entityCategory, EntityUser entityUser) {
        this.name = addBudget.getName();
        this.balance = addBudget.getBalance();
        this.date = addBudget.getDate();
        this.entityCategory = entityCategory;
        this.entityUser = entityUser;
    }

    public void setAll(UpdateBudget entityBudget, EntityCategory entityCategory) {
        this.name = entityBudget.getName();
        this.balance = entityBudget.getBalance();
        this.date = entityBudget.getDate();
        this.entityCategory = entityCategory;
    }
}
