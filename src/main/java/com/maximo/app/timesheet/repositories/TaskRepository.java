package com.maximo.app.timesheet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maximo.app.timesheet.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

}
