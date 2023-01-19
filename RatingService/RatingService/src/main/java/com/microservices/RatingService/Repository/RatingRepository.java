package com.microservices.RatingService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.RatingService.Model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {
	
	//custom finder method
	List<Rating> findByUserId(String userid);
	
	List<Rating> findByHotelId(String hotelid);
}
