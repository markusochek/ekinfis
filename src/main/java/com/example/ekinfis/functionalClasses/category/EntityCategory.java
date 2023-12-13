package com.example.ekinfis.functionalClasses.category;

import com.example.ekinfis.functionalClasses.category.dto.AddCategory;
import com.example.ekinfis.functionalClasses.category.dto.UpdateCategory;
import com.example.ekinfis.functionalClasses.user.EntityUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class EntityCategory {
    @Id
    @SequenceGenerator(name="categories_sequence",sequenceName="categories_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categories_sequence")
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private EntityUser entityUser;

    public EntityCategory(AddCategory addCategory, EntityUser entityUser) {
        this.name = addCategory.getName();
        this.entityUser = entityUser;
    }

    public void setAll(UpdateCategory entityCategory) {
        this.id = entityCategory.getId();
        this.name = entityCategory.getName();
    }
}
