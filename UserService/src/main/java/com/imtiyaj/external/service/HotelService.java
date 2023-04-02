package com.imtiyaj.external.service;

import com.imtiyaj.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name ="HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/hotel/{hotelId}")
    ResponseEntity<Hotel> getHotelById(@PathVariable(name = "hotelId") Integer hotelId);

    @PostMapping("/hotel")
    ResponseEntity<Hotel> addHotel(Hotel hotel);
}
