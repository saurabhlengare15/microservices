package com.microservices.UserService.External.Services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.UserService.Model.Hotel;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {

	@GetMapping("hotels/{hotelId}")
	Hotel getHotel(@PathVariable("hotelId") String hotelId);
}
