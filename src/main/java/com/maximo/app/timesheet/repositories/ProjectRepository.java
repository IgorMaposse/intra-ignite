package com.maximo.app.timesheet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maximo.app.timesheet.models.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
