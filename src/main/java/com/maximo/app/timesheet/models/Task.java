package com.maximo.app.timesheet.models;



import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.AssertFalse;

import com.maximo.app.parameters.models.Client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_task")
@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="task_startDate")
	private  Date startDate;
	
	@Column(name="task_duration")
	private String duration;
	
	@OneToMany
	@JoinColumn(name="projectid", insertable = false, updatable = false)
	private List<Project> projects;
	
	private Integer projectid;
	
	@OneToMany
	@JoinColumn(name="activityid", insertable = false, updatable = false)
	private List<Activity> activities;
	
	@Column(name="task_comment")
	private String comment;

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Integer getProjectid() {
		return projectid;
	}

	public void setProjectid(Integer projectid) {
		this.projectid = projectid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getduration() {
		return duration;
	}

	public void setduration(String duration) {
		this.duration = duration;
	}

	public List<Project> getProject() {
		return projects;
	}

	public void setProjectTask(List<Project> projects) {
		this.projects = projects;
	}

	public List<Activity> getActivity() {
		return activities;
	}

	public void setActivity(List<Activity> activities) {
		this.activities = activities;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", startDate=" + startDate + ", duration=" + duration + ", projects=" + projects
				+ ", projectid=" + projectid + ", activities=" + activities + ", comment=" + comment + "]";
	}

	

	


	
	//private Client client;
	/*
	@Column(name="created_at", nullable = false, updatable = false)
	@CreationTimestamp
	private Timestamp created_at;
	
	@Column(name="updated_at")
	@UpdateTimestamp
	private Timestamp updated_at;
	
	
	*/
	
	
	
	
	
	
	
	

}
