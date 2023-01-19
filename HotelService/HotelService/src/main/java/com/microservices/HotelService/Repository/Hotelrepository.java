package com.microservices.HotelService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.HotelService.Model.Hotel;

@Repository
public interface Hotelrepository extends JpaRepository<Hotel, String>{

}
