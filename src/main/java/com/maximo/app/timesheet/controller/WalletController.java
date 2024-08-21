package com.maximo.app.timesheet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maximo.app.parameters.models.Client;
import com.maximo.app.parameters.services.ClientService;
import com.maximo.app.timesheet.models.Activity;
import com.maximo.app.timesheet.models.Project;
import com.maximo.app.timesheet.models.Wallet;
import com.maximo.app.timesheet.services.ProjectService;
import com.maximo.app.timesheet.services.WalletService;


@Controller
public class WalletController {
	
	

	@Autowired
	private WalletService walletService;
	
	@Autowired
	private ClientService clientService;
	

	@GetMapping("/wallets")
   public  String getAllWallets(Model model){
		List<Wallet> wallets=walletService.getAllWallets();
	
		
		for (Wallet wallet : wallets) {
	        System.out.println("wallet: " + wallet.getName());
	    }
		model.addAttribute("wallets", wallets);
		return "pages/timeSheet/walletAdd";
	}
	
	@RequestMapping(value="/wallet/delete/{id}", method= {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteWallet(@PathVariable Integer id) {
		walletService.deleteWallet(id);
		return "redirect:/wallets";
	}
	
	@GetMapping("/walletEdit/{id}")
	public String editWallet(@PathVariable Integer id, Model model) {

		model.addAttribute("wallet", walletService.getWalletById(id));
		return "/pages/timeSheet/walletEdit";
	}
	

	
	@GetMapping("/walletAdd")
	public String walletAdd(Model model) {
		List<Client> clients=clientService.getAllClients();
	
		model.addAttribute("clients", clients);
		return "/pages/timeSheet/walletAdd";
	}
	
	@PostMapping("/wallets")
	public String saveWalletDetails(Wallet wallet) {
		
		walletService.saveWallet(wallet);
	
		return "redirect:/wallets";
	}
	
	@RequestMapping(value="/wallets/update/{id}", method= {RequestMethod.GET, RequestMethod.PUT})
	public String updateWallet(Wallet wallet) {
		walletService.saveWallet(wallet);
		return "redirect:/wallets";
	}
	
/*
	@RequestMapping(value="/projects/update/{id}", method=RequestMethod.POST)
	public String updateProject(@PathVariable Integer id, Project project) {
	    project.setId(id); // Certifica-se de que o ID é mantido no objeto
	    projectService.saveProject(project); // Atualiza o projeto
	    return "redirect:/projects";
	}*/
	/*
	@PutMapping("/projects/update/{id}")
	public Project updateProjectDetails(@RequestBody Project project, @PathVariable("id") Integer id ) {
		return projectService.updateProjectDetails(id, project);
	}*/
	
	
	
}
