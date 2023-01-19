package com.microservices.HotelService.Controller;

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

import com.microservices.HotelService.Impl.HotelServiceImpl;
import com.microservices.HotelService.Model.Hotel;

@RestController
@RequestMapping("hotels")
public class HotelController {
	
	@Autowired
	private HotelServiceImpl hotelServiceImpl;
	
	@PostMapping
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
		Hotel hotel1 = hotelServiceImpl.saveHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String id){
		Hotel h1 = hotelServiceImpl.getHotelById(id);
		return ResponseEntity.ok(h1);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel(){
		List<Hotel> allhotel = hotelServiceImpl.getAllHotel();
		return ResponseEntity.ok(allhotel);
	}
}
