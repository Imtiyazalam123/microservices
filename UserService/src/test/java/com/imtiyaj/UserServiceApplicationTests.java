package com.imtiyaj;

import com.imtiyaj.entity.Hotel;
import com.imtiyaj.external.service.HotelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.*;
@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	private HotelService hotelService;
	@Test
	void contextLoads() {
	}

//	@Test
//	void addHotelTest() {
//		Hotel hotel = Hotel.builder().about("This hotel is serving people for past 10 year with great facility.").location("Pune").name("Humsafar hotel")
//				.build();
//		ResponseEntity<Hotel> hotelResponseEntity = hotelService.addHotel(hotel);
//		Hotel newHotel = hotelResponseEntity.getBody();
//
//		assertThat(newHotel.getName()).isEqualTo("Humsafar hotel");
//	}
}
