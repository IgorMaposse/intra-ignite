package com.maximo.app.timesheet.services;

import java.util.List;

import com.maximo.app.timesheet.models.Task;

public interface TaskService {
	
	List<Task> getAllTasks();
	
	void saveTask(Task task);
	
	void delete(Integer id);
	
	public Task getTasksById(Integer id);
	

}
