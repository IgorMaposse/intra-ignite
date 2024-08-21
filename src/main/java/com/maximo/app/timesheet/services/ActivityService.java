package com.maximo.app.timesheet.services;

import java.util.List;

import com.maximo.app.timesheet.models.Activity;

public interface ActivityService {
	
	
	List<Activity> getAllActivities();
	
	void saveActivity(Activity activity);
	
	void deleteActivity(Integer id);
	
	public Activity getActivityById(Integer id);
}
