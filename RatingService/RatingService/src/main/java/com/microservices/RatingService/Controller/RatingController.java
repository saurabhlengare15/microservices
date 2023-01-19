package com.microservices.RatingService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.RatingService.Impl.RatingServiceImpl;
import com.microservices.RatingService.Model.Rating;

@RestController
@RequestMapping("ratings")
public class RatingController {

	@Autowired
	private RatingServiceImpl ratingServiceImpl;
	
	@PostMapping
	public ResponseEntity<Rating> saveRating(@RequestBody Rating rating){
		Rating rating1 = ratingServiceImpl.saveRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRating(){
		List<Rating> allrating = ratingServiceImpl.getAllRating();
		return ResponseEntity.ok(allrating);
	}
	
	@GetMapping("users/{userid}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userid){
		List<Rating> allrating = ratingServiceImpl.getRatingByUserId(userid);
		return ResponseEntity.ok(allrating);
	}
	
	@GetMapping("hotels/{hotelid}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelid){
		List<Rating> allrating = ratingServiceImpl.getRatingByHotelId(hotelid);
		return ResponseEntity.ok(allrating);
	}
}
