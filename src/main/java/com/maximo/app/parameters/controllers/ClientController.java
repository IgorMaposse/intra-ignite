package com.maximo.app.parameters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maximo.app.parameters.models.Client;
import com.maximo.app.parameters.models.Country;
import com.maximo.app.parameters.models.State;
import com.maximo.app.parameters.services.ClientService;
import com.maximo.app.parameters.services.CountryService;
import com.maximo.app.parameters.services.StateService;
import com.maximo.app.timesheet.models.Activity;
import com.maximo.app.timesheet.models.Project;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;

	@GetMapping("/clients")
   public  String getAllClients(Model model , String keyword){
		List<Client> clients;
		
		if(keyword==null) {
			clients=clientService.getAllClients();
		}else {
			clients=clientService.getByKeyword(keyword);
		}
		
		for (Client client : clients) {
	        System.out.println("Client: " + client.getName());
	    }
		model.addAttribute("clients", clients);
		return "pages/parameters/clientList";
	}
	
	@RequestMapping(value="/clients/delete/{id}", method= {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteClient(@PathVariable Integer id) {
		clientService.deleteClient(id);
		return "redirect:/clients";
	}
	
	@GetMapping("/clientEditt/{id}")
	public String editClient(@PathVariable Integer id, Model model) {
		List<Country> countries=countryService.getAllCountries();
		List<State> states=stateService.getAllStates();
		model.addAttribute("countries", countries);
		model.addAttribute("states", states);
		Client client=clientService.getClientById(id);
		model.addAttribute("client", client);
		return "/pages/parameters/clientEditt";
	}
	
	@GetMapping("/clientadd")
	public String clientAdd(Model model) {
		List<Country> countries=countryService.getAllCountries();
		List<State> states=stateService.getAllStates();
		model.addAttribute("countries", countries);
		model.addAttribute("states", states);
		return "/pages/parameters/clientAddd";
	}
	
	@PostMapping("/clients")
	public String saveClient(Client client) {
		
	clientService.saveClient(client);
	
		return "redirect:/clients";
	}
	@RequestMapping(value="/clients/update/{id}", method= {RequestMethod.GET, RequestMethod.PUT})
	public String updateClient(Client client) {
		clientService.saveClient(client);
		return "redirect:/clients";
	}
	
}
