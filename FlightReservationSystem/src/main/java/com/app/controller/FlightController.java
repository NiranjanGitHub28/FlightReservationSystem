package com.app.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Flights;
import com.app.service.IFlightService;

@Controller
@RequestMapping("/flight")
public class FlightController {
	@Autowired
	private IFlightService flightService;

	public FlightController() {
		System.out.println("In ctor of : " + getClass().getName());
	}

	@PostConstruct
	public void anyInit() {
		System.out.println("in init of " + getClass().getName() + " " + flightService);
	}

	@GetMapping("/search")
	public String showSearchForm(Model modelMap, Flights f) {
		modelMap.addAttribute("flight_details", new Flights());
		System.out.println("in show search form ");
		System.out.println(modelMap);
		return "/flight/search";

	}

	@PostMapping("/search")
	public String processSearchForm(@RequestParam String departureCity, @RequestParam String arrivalCity,
			@RequestParam(value = "departureDate") String date, Model map, HttpSession hs) {
		if (date == null || date == "") {
			hs.setAttribute("state", "Hidden");
			hs.setAttribute("status", "");
		} else {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate departureDate = LocalDate.parse(date, formatter);
			System.out.println("in process reg form : " + departureCity + " " + arrivalCity + " " + departureDate);
			try {
				List<Flights> list = flightService.getAllFlights(departureCity, arrivalCity, departureDate);
				if (list.isEmpty()) {
					hs.setAttribute("status", "No flights available!");
					hs.setAttribute("state", "hidden");
				} else {
					hs.setAttribute("status", "Available Flights..");
					hs.setAttribute("state", "");
					hs.setAttribute("flight_list", list);
					hs.setAttribute("chosen",
							"You have chosen : Flight Details : Airline : " + list.get(0).getAirline()
									+ " Arrival City : " + list.get(0).getArrivalCity() + " and Departure City : "
									+ list.get(0).getDepartureCity());
				}
			} catch (RuntimeException e) {
				System.out.println("In error controller " + e);
				map.addAttribute("status", "No flights available!");
			}
		}
		return "/flight/display";
	}

	@GetMapping("/display")
	public String showFlightList() {
		System.out.println("in show flight list");
		return "redirect:/passenger/details";
	}

}
