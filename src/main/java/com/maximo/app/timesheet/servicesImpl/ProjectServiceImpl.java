package com.maximo.app.timesheet.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.maximo.app.timesheet.models.Project;
import com.maximo.app.timesheet.repositories.ProjectRepository;
import com.maximo.app.timesheet.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository projectRepository;
	
	private Project existingProject;
	
	@Override
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		return projectRepository.findAll();
	}

	@Override
	public void saveProject(Project project) {
		// TODO Auto-generated method stub
		projectRepository.save(project);
	}

	@Override
	public void deleteProject(Integer id) {
		// TODO Auto-generated method stub
		projectRepository.deleteById(id);
	}

	@Override
	public Project getProjectById(Integer id) {
		// TODO Auto-generated method stub
		return projectRepository.getById(id);
	}

	@Override
	public Project updateProjectDetails(Integer id, Project project) {

		 existingProject=getProjectById(id);
		 existingProject.setName(project.getName());
		 existingProject.setId(project.getId());
		 

		
		return existingProject;
	}

}
