package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomePageController {
	public WelcomePageController() {
		System.out.println("in ctor of " + getClass().getName());
	}

//add a req handling method to provide a home page (index)
	@GetMapping("/")
	public String provideHomePage() {
		System.out.println("in show welcome page");
		return "/welcome";
	}

}