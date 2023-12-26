package com.example.ekinfis.functionalClasses.user;

import com.example.ekinfis.functionalClasses.allDto.Response;
import com.example.ekinfis.functionalClasses.user.dto.AddUser;
import lombok.AllArgsConstructor;
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
    public Response registration(@RequestBody AddUser addUser) throws NoSuchAlgorithmException {
        return new Response(serviceUser.registration(addUser));
    }

    @PostMapping("authorization")
    public Response authorization(@RequestBody AddUser addUser) throws NoSuchAlgorithmException {
        return new Response(serviceUser.authorization(addUser));
    }
}
