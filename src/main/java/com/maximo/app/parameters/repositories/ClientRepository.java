package com.maximo.app.parameters.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maximo.app.parameters.models.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

	
	@Query(value = "select c from Client c where " +
			"c.name LIKE %?1% or c.city LIKE %?1%")
			List<Client> getByKeyword(String keyword);
	
}
