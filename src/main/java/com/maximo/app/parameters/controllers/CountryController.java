package com.maximo.app.parameters.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import com.maximo.app.parameters.models.Country;
import com.maximo.app.parameters.services.CountryService;


@Controller
public class CountryController {
	
	
	@Autowired
	private CountryService countryService;
	
	@Bean
	public FilterRegistrationBean<HiddenHttpMethodFilter> hiddenHttpMethodFilter() {
	    FilterRegistrationBean<HiddenHttpMethodFilter> registrationBean = new FilterRegistrationBean<>();
	    registrationBean.setFilter(new HiddenHttpMethodFilter());
	    return registrationBean;
	}
	
	@GetMapping("/countries")
   public  String getAllCountries(Model model){
		List<Country> countries=countryService.getAllCountries();
	
		
		for (Country country : countries) {
	        System.out.println("Country: " + country.getDescription());
	    }
		model.addAttribute("countries", countries);
		return "pages/parameters/countryList";
	}
	
	@RequestMapping(value="/countries/delete/{id}", method= {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteCountry(@PathVariable Integer id) {
		countryService.delete(id);
		return "redirect:/countries";
	}
	
	
	@RequestMapping(value="/countries/update/{id}", method= {RequestMethod.GET, RequestMethod.PUT})
	public String updateCountry(Country country) {
		countryService.saveCountry(country);
		return "redirect:/countries";
	}
	
	@GetMapping("/countryEdit/{id}")
	public String editCountry(@PathVariable Integer id, Model model) {
		Country country=countryService.getCountryById(id);
		model.addAttribute("country", country);
		return "/pages/parameters/countryEdit";
	}
	
	@GetMapping("/countryAdd")
	public String CountryAdd() {
		return "/pages/parameters/countryAdd";
	}
	
	@PostMapping("/countries")
	public String saveTask(Country country) {
		
		countryService.saveCountry(country);
	
		return "redirect:/countries";
	}
	
	
	
	
	
	
	
	
	@GetMapping("/dashboard")
	public String test() {
		return "/pages/landing_page";
	}
	
	@GetMapping("/hr")
	public String hr() {
		return "/pages/hr/index";
	}
	
	@GetMapping("/parameters")
	public String parameters() {
		return "/pages/parameters/index";
	}

}
