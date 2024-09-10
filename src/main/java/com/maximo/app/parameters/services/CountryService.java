package com.maximo.app.parameters.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.maximo.app.parameters.models.Country;

public interface CountryService {

	
	List<Country> getAllCountries();
	
	void saveCountry(Country country);
	
	void delete(Integer id);
	
	public Country getCountryById(Integer id);
	
	   public Page<Country> findAllWithSort(String field, String direction, int pageNumber);
	   public List<Country> findByKeyword(String keyword);
	   public Page<Country> findPage(int pageNumber);
}
