package com.app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IFlightDao;
import com.app.pojos.Flights;

@Service
@Transactional
public class FlightServiceImpl implements IFlightService {
	@Autowired
	private IFlightDao flightDao;

	@Override
	public List<Flights> getAllFlights(String departureCity, String arrivalCity, LocalDate departureDate) {
		return flightDao.getAllFlights(departureCity, arrivalCity, departureDate);
	}

}
