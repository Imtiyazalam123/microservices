package com.imtiyaj.controller;

import com.imtiyaj.entity.Rating;
import com.imtiyaj.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.addRating(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {

        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatings());
    }

    @GetMapping(path = "users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUser(@PathVariable(name = "userId") Integer userId) {

        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserId(userId));
    }

    @GetMapping(path = "hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotel(@PathVariable(name = "hotelId") Integer hotelId) {

        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByHotelId(hotelId));
    }

}
