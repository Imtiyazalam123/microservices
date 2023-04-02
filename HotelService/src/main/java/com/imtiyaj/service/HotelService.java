package com.imtiyaj.service;

import com.imtiyaj.entity.Hotel;

import java.util.List;

public interface HotelService {

	public Hotel addHotel(Hotel hotel);

	public List<Hotel> getHotels();

	Hotel getHotel(Integer hotelId);
}
