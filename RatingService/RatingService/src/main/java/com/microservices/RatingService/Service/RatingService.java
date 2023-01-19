package com.microservices.RatingService.Service;

import java.util.List;

import com.microservices.RatingService.Model.Rating;

public interface RatingService {
	
	//create
	Rating saveRating(Rating rating);
	
	//getall
	List<Rating> getAllRating();
	
	//getall by userid
	List<Rating> getRatingByUserId(String userid);
	
	//getall by hotelid
	List<Rating> getRatingByHotelId(String hotelid);
	
}
