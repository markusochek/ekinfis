package com.example.ekinfis.functionalClasses.user;

import com.example.ekinfis.functionalClasses.user.dto.AddUser;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

import static org.springframework.http.ResponseEntity.ok;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("api/users")
public class ControllerUser {

    private ServiceUser serviceUser;

    @PostMapping("registration")
    public ResponseEntity<Boolean> registration(@RequestBody AddUser addUser) throws NoSuchAlgorithmException {
        return ok(serviceUser.registration(addUser));
    }

    @PostMapping("authorization")
    public ResponseEntity<String> authorization(@RequestBody AddUser addUser) throws NoSuchAlgorithmException {
        return ok(serviceUser.authorization(addUser));
    }
}
