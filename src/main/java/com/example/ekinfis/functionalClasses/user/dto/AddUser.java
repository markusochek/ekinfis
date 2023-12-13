package com.example.ekinfis.functionalClasses.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUser {
    private String login;
    private String password;
    private String rnd;
}
