package com.imtiyaj.controller;

import com.imtiyaj.entity.User;
import com.imtiyaj.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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
    @CircuitBreaker(name = "externalRatingServiceBreaker", fallbackMethod = "externalRatingServiceFallback")
    public ResponseEntity<User> getUserById(@PathVariable(name = "userId") Integer userId) {

        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    //fall back method for the above circuit breaker
//    public ResponseEntity<User> externalRatingServiceFallback(Integer userId, Exception ex) {
//        System.out.println("Rating or hotel service is down : " + ex.getMessage() + ex.getClass().getName());
//        User user = User.builder()
//                .name("Unknown")
//                .email("unknown@encora.com")
//                .about("This unknown user is created due to failure of hotel or rating service.")
//                .build();
//        return new ResponseEntity<>(user, HttpStatus.OK);
   // }
}
