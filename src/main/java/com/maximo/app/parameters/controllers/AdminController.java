package com.maximo.app.parameters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maximo.app.parameters.models.Country;
import com.maximo.app.parameters.services.CountryService;

@RestController
public class AdminController {
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping("/countriess")
	   public  String getAllCountries(Model model){
			List<Country> countries=countryService.getAllCountries();
			model.addAttribute("countries", countries);
			
			return "pages/parameters/countryList";
		}

}
