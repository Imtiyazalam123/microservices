package com.imtiyaj.service;

import com.imtiyaj.entity.Rating;

import java.util.List;

public interface RatingService {


    Rating addRating(Rating rating);

    List<Rating> getRatings();

    List<Rating> getRatingByUserId(Integer userId);

    List<Rating> getRatingByHotelId(Integer hotelId);
}
