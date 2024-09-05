package com.maximo.app.parameters.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
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

/*	@GetMapping("/clients")
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
	}*/
	
	@GetMapping("/clients")
	public String getAllPages(Model model){
	    return getAllClientsPage(model, 1);
	}
	
	@GetMapping("/clients/page/{pageNumber}")
	   public  String getAllClientsPage(Model model , @PathVariable("pageNumber") int currentPage ){
			List<Client> clients;
			Page<Client> page= clientService.getAllClientsPage(currentPage);
			int totalPages=page.getTotalPages();
			long totalItems=page.getTotalElements();
			clients=page.getContent();
			
			for (Client client : clients) {
		        System.out.println("Client: " + client.getName());
		    }
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("totalPages", totalPages);
			model.addAttribute("totalItems", totalItems);
			model.addAttribute("clients", clients);
			return "pages/parameters/clientList";
		}
		
	
	@GetMapping("/clients/page/{pageNumber}/{field}")
	   public  String getAllClientsWithSort(Model model,@PathVariable("pageNumber") int currentPage, @PathVariable("field") String field,@PathParam("sortDir") String sortDir){
			List<Client> clients;
			Page<Client> page= clientService.getAllClientsWithSort(field, sortDir, currentPage);
			
			int totalPages=page.getTotalPages();
			long totalItems=page.getTotalElements();
			clients=page.getContent();
			
			
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("totalPages", totalPages);
			model.addAttribute("totalItems", totalItems);
			model.addAttribute("sortDir", sortDir);
			
			
			if(sortDir.equals(Sort.Direction.ASC)) {
				sortDir=Sort.Direction.DESC.name();
				model.addAttribute("reverseSortDir", sortDir);
			}else {
				sortDir=Sort.Direction.ASC.name();
				model.addAttribute("reverseSortDir", sortDir);
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
