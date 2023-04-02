package com.imtiyaj.repository;

import com.imtiyaj.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, Integer> {

    List<Rating> findByUserId(Integer userId);

    List<Rating> findByHotelId(Integer hotelId);
}
