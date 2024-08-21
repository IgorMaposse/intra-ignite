package com.maximo.app.parameters.services;

import java.util.List;

import com.maximo.app.parameters.models.Client;


public interface ClientService {
	
	List<Client> getAllClients();
	
	void saveClient(Client client);
	
	void deleteClient(Integer id);
	
	public Client getClientById(Integer id);

}
