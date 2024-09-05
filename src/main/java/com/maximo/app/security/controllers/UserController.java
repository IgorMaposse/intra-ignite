package com.maximo.app.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.maximo.app.security.models.User;
import com.maximo.app.security.servicesImpl.UserService;



@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	   @PostMapping("/users/addNew")
	    public RedirectView addNew(User user, RedirectAttributes redir) {
	        userService.saveUser(user);

	        RedirectView redirectView = new RedirectView("/login", true);
	        redir.addFlashAttribute("message", "You have successfully registered a new user!");
	        return redirectView;
	    }
	
	

}
