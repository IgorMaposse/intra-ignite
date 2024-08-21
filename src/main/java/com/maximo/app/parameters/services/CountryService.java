package com.maximo.app.parameters.services;

import java.util.List;
import java.util.Optional;

import com.maximo.app.parameters.models.Country;

public interface CountryService {

	
	List<Country> getAllCountries();
	
	void saveCountry(Country country);
	
	void delete(Integer id);
	
	public Country getCountryById(Integer id);
	
	
}
