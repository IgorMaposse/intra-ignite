package com.maximo.app.parameters.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.maximo.app.parameters.models.Client;


public interface ClientService {
	
	List<Client> getAllClients();
	
	Page<Client> getAllClientsPage(int PageNumber);
	
	void saveClient(Client client);
	
	void deleteClient(Integer id);
	
	public Client getClientById(Integer id);
	
	public List<Client> getByKeyword(String keyword);
	
	Page<Client> getAllClientsWithSort(String field, String direction, int pageNumber);
	

}
