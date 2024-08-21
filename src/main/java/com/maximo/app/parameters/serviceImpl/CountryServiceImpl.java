package com.maximo.app.parameters.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.maximo.app.parameters.models.Country;
import com.maximo.app.parameters.repositories.CountryRepository;
import com.maximo.app.parameters.services.CountryService;

@Service
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	private CountryRepository countryRepository; 

	@Override
	public List<Country> getAllCountries() {
		// TODO Auto-generated method stub
		
		return countryRepository.findAll();
	}

	@Override
	public void saveCountry(Country country) {
		// TODO Auto-generated method stub
		countryRepository.save(country);
		 
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		countryRepository.deleteById(id);
		
	}

	@Override
	public Country getCountryById(Integer id) {
		// TODO Auto-generated method stub
		
		return countryRepository.findById(id).orElse(null);
	}

}
