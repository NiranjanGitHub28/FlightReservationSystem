package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Customer;
import com.app.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;

	public CustomerController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/customer/login";
	}

	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model modelMap,
			HttpSession hs) {
		System.out.println("In Process Login Form " + email + password);
		try {
			Customer cust = customerService.authenticateCustomer(email, password);

			// VALID LOGIN
			hs.setAttribute("message", "Hello, " + cust.getName());
		} catch (RuntimeException e) {
			System.out.println("In Error Controller " + e);
			modelMap.addAttribute("message", "No Such Customer, Please Retry!");
			// INVALID LOGIN
			return "/customer/login";
		}
		return "redirect:/flight/search";
	}

}
