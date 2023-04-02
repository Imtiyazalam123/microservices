package com.imtiyaj.service;

import com.imtiyaj.entity.Hotel;
import com.imtiyaj.entity.Rating;
import com.imtiyaj.entity.User;
import com.imtiyaj.exception.ResourceNotFoundException;
import com.imtiyaj.external.service.HotelService;
import com.imtiyaj.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Value("${rating-base.url}")
    private String baseUrl;
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = userRepository.findAll();
        List<User> collect = users.stream().map((user) -> {
                    Rating[] ratingArr = restTemplate.getForObject(baseUrl + "/ratings/users/" + user.getId(), Rating[].class);
                    List<Rating> ratings = Arrays.asList(ratingArr);
                    /**
                     * Feting hotel of particular rating and setting hotel to each rating
                     */
                    ratings.forEach(rating -> {
                        //  ResponseEntity<Hotel> hotelResponse = restTemplate.getForEntity("http://localhost:8585/hotel/" + rating.getHotelId(), Hotel.class);
                        /**
                         * Calling hotel service using feign client service instead of using restTemplate.
                         */
                        ResponseEntity<Hotel> hotelResponse = hotelService.getHotelById(rating.getHotelId());
                        Hotel hotel = hotelResponse.getBody();
                        rating.setHotel(hotel);
                    });

                    user.setRatings(ratings);
                    return user;
                }
        ).collect(Collectors.toList());
        return collect;
    }

    @Override
    public User getUserById(Integer id) {

        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Unable to get user with provided id " + id));
        Rating[] ratingArr = restTemplate.getForObject(baseUrl + "/ratings/users/" + id, Rating[].class);
        List<Rating> ratings = Arrays.asList(ratingArr);
        logger.info("Ratings fetched from rating service : {}", ratings);

        /**
         * Getting hotel for specific hotel id of the user.
         */
        List<Rating> ratingList = ratings.stream().map(rating -> {

            ResponseEntity<Hotel> responseHotel = restTemplate.getForEntity("http://localhost:8585/hotel/" + rating.getHotelId(), Hotel.class);
            Hotel hotel = responseHotel.getBody();
            logger.info("hotel : {}", hotel);
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }
}
