package com.imtiyaj.controller;

import com.imtiyaj.entity.Hotel;
import com.imtiyaj.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@PostMapping
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {

		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.addHotel(hotel));
	}

	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel() {

		return ResponseEntity.ok(hotelService.getHotels());
	}

	@GetMapping(path = "/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable(name = "hotelId") Integer hotelId) {

		return ResponseEntity.ok(hotelService.getHotel(hotelId));
	}
}
