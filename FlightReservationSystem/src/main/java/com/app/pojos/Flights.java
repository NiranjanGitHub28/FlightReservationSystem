package com.app.pojos;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "flights")
public class Flights extends BaseEntity{
	@Column(length = 10)
	@NotBlank(message = "Airline is required")
	private String airline;
	
	@Column(length = 20,name = "dep_city")
	@NotBlank(message = "Departure City is required")
	private String departureCity;
	
	@Column(length = 20,name = "arrival_city")
	@NotBlank(message = "Arrival City is required")
	private String arrivalCity;
	
	@Column(name="dep_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future
	private LocalDate departureDate;
	
	@Column(name="dep_time")
	@DateTimeFormat(pattern = " HH:mm:ss")
	@Future
	private LocalTime departureTime;
	
	
	public Flights() {
		System.out.println("In Flights Constructor ");
	}
	
	

	public Flights(String airline,String departureCity,String arrivalCity,LocalDate departureDate,LocalTime departureTime) {
		super();
		this.airline = airline;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
	}

	public String getAirline() {
		return airline;
	}



	public void setAirline(String airline) {
		this.airline = airline;
	}



	public String getDepartureCity() {
		return departureCity;
	}



	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}



	public String getArrivalCity() {
		return arrivalCity;
	}



	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}



	public LocalDate getDepartureDate() {
		return departureDate;
	}



	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}



	public LocalTime getDepartureTime() {
		return departureTime;
	}



	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}


	@Override
	public String toString() {
		return "Flights [airline=" + airline + ", departureCity=" + departureCity + ", arrivalCity=" + arrivalCity
				+ ", departureDate=" + departureDate + ", departureTime=" + departureTime + "]";
	}
	
	
}
