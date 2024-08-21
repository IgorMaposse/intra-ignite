package com.maximo.app.parameters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maximo.app.parameters.models.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
