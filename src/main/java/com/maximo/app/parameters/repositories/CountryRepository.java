package com.maximo.app.parameters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maximo.app.parameters.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer> {

}
