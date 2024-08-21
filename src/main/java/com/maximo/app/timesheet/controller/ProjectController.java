package com.maximo.app.timesheet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.maximo.app.timesheet.models.Project;

import com.maximo.app.timesheet.services.ProjectService;


@Controller
public class ProjectController {
	
	
	
	@Autowired
	private ProjectService projectService;
	
	

	@GetMapping("/projects")
   public  String getAllProjects(Model model){
		List<Project> projects=projectService.getAllProjects();
	
		
		for (Project project : projects) {
	        System.out.println("project: " + project.getName());
	    }
		model.addAttribute("projects", projects);
		return "pages/timeSheet/projectList";
	}
	
	@RequestMapping(value="/project/delete/{id}", method= {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteProject(@PathVariable Integer id) {
		projectService.deleteProject(id);
		return "redirect:/projects";
	}
	
	@GetMapping("/projectEdit/{id}")
	public String editProject(@PathVariable Integer id, Model model) {

		model.addAttribute("project", projectService.getProjectById(id));
		return "/pages/timeSheet/projectEdit";
	}
	

	
	@GetMapping("/projectAdd")
	public String projectAdd() {
	
		return "/pages/timeSheet/projectAdd";
	}
	
	@PostMapping("/projects")
	public String saveProjectDetails(Project project) {
		
		projectService.saveProject(project);
	
		return "redirect:/projects";
	}
	
	@RequestMapping(value="/projects/update/{id}", method= {RequestMethod.GET, RequestMethod.PUT})
	public String updateProject(Project project) {
		projectService.saveProject(project);
		return "redirect:/projects";
	}
	
/*
	@RequestMapping(value="/projects/update/{id}", method=RequestMethod.POST)
	public String updateProject(@PathVariable Integer id, Project project) {
	    project.setId(id); // Certifica-se de que o ID é mantido no objeto
	    projectService.saveProject(project); // Atualiza o projeto
	    return "redirect:/projects";
	}*/
	/*
	@PutMapping("/projects/update/{id}")
	public Project updateProjectDetails(@RequestBody Project project, @PathVariable("id") Integer id ) {
		return projectService.updateProjectDetails(id, project);
	}*/
	
	
	
}
