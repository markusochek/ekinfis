package com.example.ekinfis.functionalClasses.user;

import com.example.ekinfis.functionalClasses.user.dto.AddUser;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
@AllArgsConstructor
public class ServiceUser {
    private RepositoryUser repositoryUser;

    public Boolean registration(AddUser addUser) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update((addUser.getLogin() + addUser.getPassword()).getBytes());
        md.update(((addUser.getLogin() + addUser.getPassword()) + md).getBytes());
        String encodedPassword = DatatypeConverter.printHexBinary(md.digest()).toUpperCase();

        if (!repositoryUser.existsByLogin(addUser.getLogin())) {
            repositoryUser.save(new EntityUser(null, addUser.getLogin(), encodedPassword, ""));
            return true;
        }
        return false;
    }

    public String authorization(AddUser addUser) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update((addUser.getLogin() + addUser.getPassword()).getBytes());
        md.update(((addUser.getLogin() + addUser.getPassword()) + md).getBytes());
        String encodedPassword = DatatypeConverter.printHexBinary(md.digest()).toUpperCase();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String token = encoder.encode(addUser.getLogin() + addUser.getPassword());

        if (repositoryUser.existsByLogin(addUser.getLogin())) {
            EntityUser userEntity = repositoryUser.findByLoginAndPassword(addUser.getLogin(), encodedPassword).orElseThrow(() -> new RuntimeException("Could not find user"));
            userEntity.setToken(token);
            repositoryUser.save(userEntity);
            return token;
        }
        return null;
    }
}
