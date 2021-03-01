package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Flights;

@Repository
public class FlightDaoImpl implements IFlightDao {
	@Autowired //dependency : SessionFactory
	private EntityManager mgr;
	
	@Override
	public List<Flights> getAllFlights(String departureCity, String arrivalCity, LocalDate departureDate) {
		String jpql="select f from Flights f where f.departureCity=:departureCity and f.arrivalCity=:arrivalCity "
				+ "and f.departureDate=:departureDate";
		
		return mgr.createQuery(jpql,Flights.class).setParameter("departureCity", departureCity)
				.setParameter("arrivalCity", arrivalCity).setParameter("departureDate", departureDate)
				.getResultList();
	}

}
