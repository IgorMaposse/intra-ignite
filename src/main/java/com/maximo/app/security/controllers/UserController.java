package com.maximo.app.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.maximo.app.security.models.User;
import com.maximo.app.security.servicesImpl.RolesService;
import com.maximo.app.security.servicesImpl.UserService;



@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	

    @Autowired
    private RolesService roleService;

	
	   @PostMapping("/users/addNew")
	    public RedirectView addNew(User user, RedirectAttributes redir) {
	        userService.saveUser(user);

	        RedirectView redirectView = new RedirectView("/login", true);
	        redir.addFlashAttribute("message", "You have successfully registered a new user!");
	        return redirectView;
	    }

	    @GetMapping("/security/users")
	    public String getAll(Model model) {
	        model.addAttribute("users", userService.findAll());
	        return "pages/security/users";
	    }
/*
	    @GetMapping("/security/user/{op}/{id}")
	    public String editUser(@PathVariable Integer id, @PathVariable String op, Model model) {
	        User user = userService.findById(id);
	        model.addAttribute("user", user);
	        model.addAttribute("userRoles", roleService.getUserRoles(user));
	        model.addAttribute("userNotRoles", roleService.getUserNotRoles(user));
	        return "/security/user" + op; //returns employeeEdit or employeeDetails
	    }

	 
	*/

}
