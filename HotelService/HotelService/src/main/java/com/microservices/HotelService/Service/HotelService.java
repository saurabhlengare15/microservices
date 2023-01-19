package com.microservices.HotelService.Service;

import java.util.List;

import com.microservices.HotelService.Model.Hotel;

public interface HotelService {
	
	//create
	Hotel saveHotel(Hotel hotel);
	
	//get
	Hotel getHotelById(String id);
	
	//getall
	List<Hotel> getAllHotel();
	
}
