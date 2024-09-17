package com.maximo.app.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	
	
	@RequestMapping("/login")
	public String LoginPage() {
		return "/pages/security/login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "/pages/security/register";
	}
	@RequestMapping("/security")
	public String homePage() {
		return "/pages/security/index";
	}
	   @GetMapping("/accessDenied")
	    public String accessDenied() {
	        return "pages/accessDenied";
	    }

}
