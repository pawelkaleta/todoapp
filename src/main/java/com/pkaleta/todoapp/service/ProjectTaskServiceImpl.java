package com.pkaleta.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pkaleta.todoapp.dao.ProjectDAO;
import com.pkaleta.todoapp.dao.TaskDAO;
import com.pkaleta.todoapp.model.Project;
import com.pkaleta.todoapp.model.Task;

@Service("projectTaskService")
@Transactional
public class ProjectTaskServiceImpl implements ProjectTaskService {

	 @Autowired
	 private ProjectDAO projectDAO;
	 
	 @Autowired
	 private TaskDAO taskDAO;
	 

	public void saveProject(Project project) {
		projectDAO.saveProject(project);
	}

	public List<Project> findAllUserProjects(int id) {
		return projectDAO.findAllUserProjects(id);
	}

	public Project findProjectById(int id) {
		return projectDAO.findProjectById(id);
	}

	public void deleteProjectById(int id) {
		projectDAO.deleteProjectById(id);
	}

	public void updateProject(Project project) {
		projectDAO.updateProject(project);		
	}

	public void saveTask(Task task) {
		taskDAO.saveTask(task);
		
	}

	public List<Task> findAllProjectTasks(int id) {
		return taskDAO.findAllProjectTasks(id);
	}

	public Task findTaskById(int id) {
		return taskDAO.findTaskById(id);
	}

	public void deleteTaskById(int id) {
		taskDAO.deleteTaskById(id);
	}

	public void updateTask(Task task) {
		taskDAO.updateTask(task);
	}

}
