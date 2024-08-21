package com.maximo.app.timesheet.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maximo.app.timesheet.models.Task;
import com.maximo.app.timesheet.repositories.TaskRepository;
import com.maximo.app.timesheet.services.TaskService;

@Service
public class TaskServiceImpl  implements TaskService{
	
	@Autowired
	private TaskRepository taskRepository;	

	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}

	@Override
	public void saveTask(Task task) {
		// TODO Auto-generated method stub
		taskRepository.save(task);
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		taskRepository.deleteById(id);
	}



	@Override
	public Task getTasksById(Integer id) {
		// TODO Auto-generated method stub
		return taskRepository.findById(id).orElse(null);
	}

}
