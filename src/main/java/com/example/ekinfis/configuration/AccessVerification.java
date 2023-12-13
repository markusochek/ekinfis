package com.example.ekinfis.configuration;

import com.example.ekinfis.functionalClasses.user.EntityUser;
import com.example.ekinfis.functionalClasses.user.RepositoryUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service("AccessVerification")
@AllArgsConstructor
public class AccessVerification {
    RepositoryUser repositoryUser;

    public boolean checkToken(String token) {
        return repositoryUser.existsByToken(token);
    }
}
