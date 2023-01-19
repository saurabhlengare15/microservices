package com.microservices.HotelService.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservices.HotelService.Model.Hotel;
import com.microservices.HotelService.Repository.Hotelrepository;
import com.microservices.HotelService.Service.HotelService;
import com.microservices.HotelService.Exceptions.ResourceNotFoundException;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private Hotelrepository hotelrepository;

	@Override
	public Hotel saveHotel(Hotel hotel) {
		String hotelid =  UUID.randomUUID().toString();
		hotel.setId(hotelid);
		return hotelrepository.save(hotel);
	}

	@Override
	public Hotel getHotelById(String id) {
		return hotelrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id is not found"));
	}

	@Override
	public List<Hotel> getAllHotel() {
		return hotelrepository.findAll();
	}

}
