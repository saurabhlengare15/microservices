package com.microservices.UserService.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.UserService.Exceptions.ResourceNotFoundException;
import com.microservices.UserService.External.Services.HotelService;
import com.microservices.UserService.Model.Hotel;
import com.microservices.UserService.Model.Rating;
import com.microservices.UserService.Model.User;
import com.microservices.UserService.Repository.UserRepository;
import com.microservices.UserService.Service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	

	@Override
	public User saveUser(User user) {
		//generate unique userid
		String userId = UUID.randomUUID().toString();
		user.setUserid(userId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(String id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server!!!"+id));
		
		//fetch rating of above user from rating service
		//http://localhost:8083/ratings/users/08315c6d-c6ef-4e2c-ab18-a1814e803ef5
		Rating[] ratingsofUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserid(), Rating[].class);
		
		List<Rating> ratings = Arrays.asList(ratingsofUser);
		
		List<Rating> ratingList = ratings.stream().map(rating -> {
			//api call to hotel service to get the hotel
			//http://localhost:8082/hotels/5703ee4a-8d91-413c-9fe6-b76a096aeee5
			
//			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			
			//set hotel to rating
			rating.setHotel(hotel);
			
			//return rating
			return rating;
		}).collect(Collectors.toList());
		
		user.setRatings(ratingList);
		
		return user;
	}

}
