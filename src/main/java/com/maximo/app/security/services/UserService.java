package com.maximo.app.security.services;

import java.util.List;

import com.maximo.app.security.models.User;

public interface UserService {
	
	
	public void saveUser(User user);
	 public List<User> findAll();
	 public User findById(int id) ;
	 public void delete(int id);

}
