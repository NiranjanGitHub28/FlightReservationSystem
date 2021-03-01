package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Passenger;
import com.app.service.IPassengerService;

@Controller
@RequestMapping("/passenger")
public class PassengerController {
	@Autowired
	private IPassengerService passService;

	Passenger pp = new Passenger();

	public PassengerController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	@GetMapping("/details")
	public String showRegForm(Model modelMap, Passenger p) {
		System.out.println("in show reg form ");

		return "/passenger/details";
	}

	@PostMapping("/details")

	public String prcessRegForm(Passenger p, RedirectAttributes fs) {
		System.out.println("In show Passenger reg " + p);
		pp = p;
		fs.addFlashAttribute("pass_details", p);
		return "redirect:/passenger/cardDetails";
	}

	@GetMapping("/cardDetails")
	public String showCardDetails(Model modelMap, Passenger p) {
		System.out.println("in process Card Details form");
		return "/passenger/cardDetails";
	}

	@PostMapping("/cardDetails")
	public String processCardDetails(Passenger p, RedirectAttributes fs, BindingResult rs, Model modelMap,
			HttpSession hs) {
		p.setName(pp.getName());
		p.setEmail(pp.getEmail());
		p.setId(pp.getId());
		p.setPhoneNos(pp.getPhoneNos());
		System.out.println("in process reg form : vendor dtls " + p);
		System.out.println("Card dtls " + p.getDetails());
		System.out.println("binding result " + rs);
		// chk for P.L errors
		if (rs.hasErrors()) {
			System.out.println("in P.L validation failure");
			return "/passenger/cardDetails";
		}

		fs.addFlashAttribute("pass_details", passService.registerPassenger(p));
		hs.setAttribute("user_details", p);
		hs.setAttribute("idmessage", "Reservation Done With ID: " + p.getId());
		return "redirect:/passenger/status";
	}

	@GetMapping("/status")
	public String showStatus(HttpSession session, HttpServletRequest request, HttpServletResponse resp) {
		System.out.println("in Status page ");
		resp.setHeader("refresh", "5;url=" + request.getContextPath());
		return "/passenger/status";

	}
}