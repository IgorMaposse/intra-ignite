package com.maximo.app.parameters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maximo.app.parameters.models.State;

public interface StateRepository extends JpaRepository<State, Integer> {

}
