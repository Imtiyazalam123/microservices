package com.imtiyaj.controller;

import com.imtiyaj.entity.User;
import com.imtiyaj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {

        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }

    @GetMapping(path = "{userId}")
    public ResponseEntity<User> getUserById(@PathVariable(name = "userId") Integer userId) {

        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }
}
