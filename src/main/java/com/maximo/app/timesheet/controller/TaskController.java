package com.maximo.app.timesheet.controller;

import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maximo.app.parameters.controllers.CustomTimeEditor;
import com.maximo.app.timesheet.models.Activity;
import com.maximo.app.timesheet.models.Project;

import com.maximo.app.timesheet.models.Task;
import com.maximo.app.timesheet.services.ActivityService;

import com.maximo.app.timesheet.services.ProjectService;

import com.maximo.app.timesheet.services.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ActivityService activityService;
	
	
	  @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        binder.registerCustomEditor(Time.class, new CustomTimeEditor());
	    }
	  
	  
	  public Model addModelAttribute(Model model){
		  model.addAttribute("projects", projectService.getAllProjects());
		//  model.addAttribute("activities", projectActivityService.getAllActivities());
		  
		  return model;
	  }

	@GetMapping("/tasks")
   public  String getAllTasks(Model model){
		List<Task> tasks=taskService.getAllTasks();
	
		for (Task task : tasks) {
	        System.out.println("Country: " + task.getComment());
	    }
		model.addAttribute("tasks", tasks);
		return "pages/timeSheet/taskList";
	}
	
	@RequestMapping(value="/tasks/delete/{id}", method= {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteTask(@PathVariable Integer id) {
		taskService.delete(id);
		return "redirect:/tasks";
	}
	
	@GetMapping("/taskEdit/{id}")
	public String editTask(@PathVariable Integer id, Model model) {
		Task task=taskService.getTasksById(id);
		model.addAttribute("task", task);
		return "/pages/timeSheet/taskEdit";
	}
	
	@GetMapping("/taskAdd")
	public String taskAdd(Model model) {
		
		List<Project> projects=projectService.getAllProjects();
		List<Activity> activities=activityService.getAllActivities();
		model.addAttribute("projects", projects);
		model.addAttribute("activities", activities);
		//addModelAttribute(model);
		return "/pages/timeSheet/taskAdd";
	}
	
	@PostMapping("/tasks")
	public String saveTaskDetails(Task task) {
		
		taskService.saveTask(task);
	
		return "redirect:/tasks";
	}
	
	
	@RequestMapping(value="/tasks/update/{id}", method= {RequestMethod.GET, RequestMethod.PUT})
	public String updateTask(Task task) {
		taskService.saveTask(task);
		return "redirect:/tasks";
	}
	

}
