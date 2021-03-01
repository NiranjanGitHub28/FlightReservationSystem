package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.pojos.Flights;

public interface IFlightService {
	//add a method to search available flights 
		List<Flights> getAllFlights(String departureCity , String arrivalCity, LocalDate departureDate);
}
