package com.maximo.app.timesheet.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maximo.app.timesheet.models.Activity;
import com.maximo.app.timesheet.repositories.ActivityRepository;
import com.maximo.app.timesheet.services.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService{
	
	@Autowired
	private ActivityRepository activityRepository;

	@Override
	public List<Activity> getAllActivities() {
		// TODO Auto-generated method stubWWW
		return activityRepository.findAll();
	}

	@Override
	public void saveActivity(Activity activity) {
		// TODO Auto-generated method stub
		activityRepository.save(activity);
		
	}

	@Override
	public void deleteActivity(Integer id) {
		// TODO Auto-generated method stub
		activityRepository.deleteById(id);
		
	}

	@Override
	public Activity getActivityById(Integer id) {
		// TODO Auto-generated method stub
		return activityRepository.findById(id).orElseThrow(null);
	}

}
