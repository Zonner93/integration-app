package com.integration.integrationapp.controller.controller;

import com.integration.integrationapp.models.dto.UserDto;
import com.integration.integrationapp.models.entity.Event;
import com.integration.integrationapp.models.entity.User;
import com.integration.integrationapp.models.mapper.CategoryMapper;
import com.integration.integrationapp.models.mapper.UserMapper;
import com.integration.integrationapp.repository.EventRepository;
import com.integration.integrationapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequestMapping(path = "api/v1/users")
@RestController
public class UserController {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final CategoryMapper categoryMapper;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserRepository userRepository, EventRepository eventRepository, CategoryMapper categoryMapper, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.categoryMapper = categoryMapper;
        this.userMapper = userMapper;
    }

    @PostMapping(path = "/login")
    ResponseEntity<?> loginUsers(@RequestParam String email, @RequestParam String password ) {
        User result = userRepository.findByEmail(email);
        if(result != null && Objects.equals(result.getPassword(), password)){
            return new ResponseEntity<>(
                    userMapper.entityToDto(result),HttpStatus.OK
            );
        }
        return new ResponseEntity<>(
                "Unauthorized", HttpStatus.UNAUTHORIZED
        );
    }

    @PutMapping(path = "/event")
    ResponseEntity<?> registerToActiveEvent(@RequestParam Long user_id,
                                            @RequestParam Long event_id) {
        User user = userRepository.getById(user_id);
        Set<Event> events = user.getParticipatesIn();
        events.add(eventRepository.getById(event_id));
        user.setParticipatesIn(events);
        userRepository.save(user);

        return new ResponseEntity<>(
                "OK", HttpStatus.OK
        );

    }

    @GetMapping(path = "/all")
    List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(
                userMapper::entityToDto
        ).collect(Collectors.toList());
    }

    @GetMapping(path = "/categories/")
    ResponseEntity<?> getUserCategories(@RequestParam Long id){
        Optional<User> result = userRepository.findById(id);

        if(result.isPresent())
            return new ResponseEntity<>(
                    (result.get().getCategories().stream()
                            .map(categoryMapper::entityToDto)
                            .collect(Collectors.toList()))
                    ,HttpStatus.OK
            );

        return new ResponseEntity<>(
                "Not Found", HttpStatus.NOT_FOUND
        );
    }


}
