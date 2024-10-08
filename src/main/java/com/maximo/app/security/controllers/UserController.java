package com.maximo.app.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.maximo.app.security.models.User;
import com.maximo.app.security.servicesImpl.RolesService;
import com.maximo.app.security.servicesImpl.UserServiceImpl;



@Controller
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	

    @Autowired
    private RolesService roleService;

	
    
    	
	   @PostMapping("/users/addNew")
	    public RedirectView addNew(User user, RedirectAttributes redir) {
		 System.out.println(user.getUsername()+ ""+user.getFirstName()+""+user.getLastName());
	        userService.saveUser(user);
	        System.out.println(user.getFirstName()+""+user.getLastName());
	        RedirectView redirectView = new RedirectView("/login", true);
	        redir.addFlashAttribute("message", "You have successfully registered a new user!");
	        return redirectView;
	    }

	    @GetMapping("/security/users")
	    public String getAll(Model model) {
	        model.addAttribute("users", userService.findAll());
	        return "pages/security/users";
	    }

	    @GetMapping("/security/userEdit/{id}")
	    public String editUser(@PathVariable Integer id, Model model) {
	        User user = userService.findById(id);
	        model.addAttribute("user", user);
	        model.addAttribute("userRoles", roleService.getUserRoles(user));
	        model.addAttribute("userNotRoles", roleService.getUserNotRoles(user));
	        return "pages/security/userEdit"; 
	    }

	 
	

}
