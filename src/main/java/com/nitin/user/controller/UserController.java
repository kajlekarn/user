package com.nitin.user.controller;

import com.nitin.user.model.User;
import com.nitin.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.getUserById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUserById(id, user));
    }
}
