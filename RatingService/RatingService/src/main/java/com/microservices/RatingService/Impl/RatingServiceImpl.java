package com.microservices.RatingService.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.RatingService.Exception.ResourceNotFoundException;
import com.microservices.RatingService.Model.Rating;
import com.microservices.RatingService.Repository.RatingRepository;
import com.microservices.RatingService.Service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating saveRating(Rating rating) {
		String ratingid =  UUID.randomUUID().toString();
		rating.setRatingId(ratingid);
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userid) {
		return ratingRepository.findByUserId(userid);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelid) {
		return ratingRepository.findByHotelId(hotelid);
	}

}
