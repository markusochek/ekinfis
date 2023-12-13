package com.example.ekinfis.functionalClasses.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class EntityUser {
    @Id
    @SequenceGenerator(name="users_sequence",sequenceName="users_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    private Integer id;
    private String login;
    private String password;
    private String token;
}
