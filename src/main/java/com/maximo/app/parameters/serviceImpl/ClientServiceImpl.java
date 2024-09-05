package com.maximo.app.parameters.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	@Override
	public List<Client> getByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return clientRepository.getByKeyword(keyword);
	}

	@Override
	public Page<Client> getAllClientsWithSort(String field, String direction,int pageNumber) {
		// TODO Auto-generated method stub
		Sort sort = Sort.by(Sort.Direction.ASC.name());
		
		direction=Sort.Direction.ASC.name();
		
		if(direction.equalsIgnoreCase(Sort.Direction.ASC.name())) {
			
			Sort.by(field).ascending();	
		}else {
			Sort.by(field).descending();
		}
		Pageable pageable=PageRequest.of(pageNumber-1, 5,sort);
		return clientRepository.findAll(pageable);
	}

	@Override
	public Page<Client> getAllClientsPage(int PageNumber) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(PageNumber-1, 5);
		
		return clientRepository.findAll(pageable);
	}



}
