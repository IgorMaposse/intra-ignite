package com.maximo.app.timesheet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maximo.app.timesheet.models.Activity;
import com.maximo.app.timesheet.models.Project;
import com.maximo.app.timesheet.services.ActivityService;


@Controller
public class ActivityController {
	
	@Autowired
	private ActivityService activityService;
	

	@GetMapping("/activities")
	public  String getAllActivities(Model model){
		List<Activity> activities=activityService.getAllActivities();
	
		
		for (Activity activity : activities) {
	        System.out.println("Client: " + activity.getName());
	    }
		model.addAttribute("activities", activities);
		return "pages/timeSheet/activityList";
	}
	
	@RequestMapping(value="/activity/delete/{id}", method= {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteActivity(@PathVariable Integer id) {
		activityService.deleteActivity(id);
		return "redirect:/activities";
	}
	
	@GetMapping("/activityEdit/{id}")
	public String editactivity(@PathVariable Integer id, Model model) {
		
		model.addAttribute("activity", activityService.getActivityById(id));
		return "/pages/timeSheet/activityEdit";
	}
	
	@GetMapping("/activityAdd")
	public String activityAdd() {
		return "/pages/timeSheet/activityAdd";
	}
	
	@PostMapping("/activities")
	public String saveactivity(Activity activity) {
		
		activityService.saveActivity(activity);
	
		return "redirect:/activities";
	}
	
	@RequestMapping(value="/activities/update/{id}", method= {RequestMethod.GET, RequestMethod.PUT})
	public String updateActivity(Activity activity) {
		activityService.saveActivity(activity);
		return "redirect:/activities";
	}
	/*
	@RequestMapping(value="/activity/update/{id}", method= {RequestMethod.GET, RequestMethod.PUT})
	public String updateActivity(Activity activity) {
		activityService.saveActivity(activity);
		return "redirect:/activities";
	}*/
	
	
	

}
