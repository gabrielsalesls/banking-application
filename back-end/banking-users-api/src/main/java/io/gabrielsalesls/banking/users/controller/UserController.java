package io.gabrielsalesls.banking.users.controller;

import io.gabrielsalesls.banking.users.model.User;
import io.gabrielsalesls.banking.users.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    @Transactional
    public ResponseEntity<List<User>> findAll() {

        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User users) {
        return new ResponseEntity<>(userRepository.save(users), HttpStatus.CREATED);
    }

}
