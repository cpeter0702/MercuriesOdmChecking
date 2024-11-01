package com.firsttech.insurance.odm_checking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WelcomeController {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome to spring boot app development";
	}
}
