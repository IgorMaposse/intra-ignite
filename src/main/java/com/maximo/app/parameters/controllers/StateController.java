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
import com.maximo.app.parameters.models.State;
import com.maximo.app.parameters.services.CountryService;
import com.maximo.app.parameters.services.StateService;


@Controller
public class StateController {
	
	
	@Autowired
	private StateService stateService;

	
	@GetMapping("/states")
   public  String getAllStates(Model model){
		List<State> states=stateService.getAllStates();
	
		
		for (State state : states) {
	        System.out.println("State: " + state.getName());
	    }
		model.addAttribute("states", states);
		return "pages/parameters/stateList";
	}
	
	@RequestMapping(value="/states/delete/{id}", method= {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteStates(@PathVariable Integer id) {
		stateService.deleteState(id);
		return "redirect:/states";
	}
	
	
	@RequestMapping(value="/states/update/{id}", method= {RequestMethod.GET, RequestMethod.PUT})
	public String updateStates(State state) {
		stateService.saveState(state);
		return "redirect:/states";
	}
	
	@GetMapping("/stateEdit/{id}")
	public String editState(@PathVariable Integer id, Model model) {
		State state=stateService.getStateById(id);
		model.addAttribute("state", state);
		return "/pages/parameters/stateEdit";
	}
	
	@GetMapping("/stateAdd")
	public String StateAdd() {
		return "/pages/parameters/stateAdd";
	}
	
	@PostMapping("/states")
	public String saveState(State state) {
		
		stateService.saveState(state);
	
		return "redirect:/states";
	}
	
	
	
	
	
	
	
	
	

}
