package com.integration.integrationapp.controller.controller;

import com.integration.integrationapp.models.entity.User;
import com.integration.integrationapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/v1/users")
@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping(path = "/all")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
