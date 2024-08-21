package com.maximo.app.timesheet.services;

import java.util.List;


import com.maximo.app.timesheet.models.Project;

public interface ProjectService {

	

	List<Project> getAllProjects();
	
	void saveProject(Project project);
	
	void deleteProject(Integer id);
	
	public Project getProjectById(Integer id);
	
	Project updateProjectDetails(Integer id, Project project);

}
