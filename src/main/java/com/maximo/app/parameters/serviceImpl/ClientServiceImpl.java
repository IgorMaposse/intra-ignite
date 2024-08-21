package com.maximo.app.parameters.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maximo.app.parameters.models.Client;
import com.maximo.app.parameters.repositories.ClientRepository;
import com.maximo.app.parameters.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public void saveClient(Client client) {
		// TODO Auto-generated method stub
		clientRepository.save(client);
		
	}

	@Override
	public void deleteClient(Integer id) {
		// TODO Auto-generated method stub
		clientRepository.deleteById(id);
	}

	@Override
	public Client getClientById(Integer id) {
		// TODO Auto-generated method stub
		return clientRepository.findById(id).orElse(null);
	}

}
