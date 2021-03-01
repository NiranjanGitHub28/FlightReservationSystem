package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import com.app.pojos.Flights;

public interface IFlightDao {

	List<Flights> getAllFlights(String departureCity, String arrivalCity, LocalDate departureDate);
}
