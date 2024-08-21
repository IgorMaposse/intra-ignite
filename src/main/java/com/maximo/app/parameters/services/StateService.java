package com.maximo.app.parameters.services;

import java.util.List;

import com.maximo.app.parameters.models.State;


public interface StateService {
List<State> getAllStates();
	
	void saveState(State state);
	
	void deleteState(Integer id);
	
	public State getStateById(Integer id);
	

}
