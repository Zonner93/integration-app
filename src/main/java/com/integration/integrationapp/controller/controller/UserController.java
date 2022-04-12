package com.integration.integrationapp.controller.controller;

import com.integration.integrationapp.models.entity.User;
import com.integration.integrationapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RequestMapping(path = "api/v1/users")
@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "/login")
    ResponseEntity<?> loginUsers(@RequestParam String email, @RequestParam String password ) {
        User result = userRepository.findByEmail(email);
        if(result != null && Objects.equals(result.getPassword(), password)){
            return new ResponseEntity<>(
                    result,HttpStatus.OK
            );
        }
        return new ResponseEntity<>(
                "Unauthorized", HttpStatus.UNAUTHORIZED
        );

    }

    @GetMapping(path = "/all")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
