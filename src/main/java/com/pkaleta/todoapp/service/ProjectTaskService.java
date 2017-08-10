package com.pkaleta.todoapp.service;

import java.util.List;

import com.pkaleta.todoapp.model.Project;
import com.pkaleta.todoapp.model.Task;

/**
 * 
 * @author pkaleta
 * 
 * Interface of Spring component-service, that allows to operate on db through ProjectDAO and TaskDAO interfaces
 *
 */

public interface ProjectTaskService {
	

	/**
	 * Save project object in db
	 * @param project Project object
	 */
	void saveProject(Project project);
	
	
	/**
     * Get raw list of all Project from db by User id
     * @return List of Projects
     */
	List<Project> findAllUserProjects(int id);
	
	/**
     * Look for Project with ID that's equal to param
     * @param id Project's id to find
     * @return Project object
     */
	Project findProjectById(int id);
	
	 /**
     * Delete Project from db, which ID's is equal to param
     * @param id Project's id to delete
     */
	void deleteProjectById(int id);
	
	 /**
     * Update project
     * @param project Project object
     */
	void updateProject(Project project);
	

	/**
	 * Save task object in db
	 * @param task Task object
	 */
	void saveTask(Task task);
	
	
	/**
     * Get raw list of all Tasks from db by Project id
     * @return List of Tasks
     */
	List<Task> findAllProjectTasks(int id);
	
	
	/**
     * Look for Tasks with ID that's equal to param
     * @param id Tasks's id to find
     * @return Tasks object
     */
	Task findTaskById(int id);
	  
	 /**
     * Delete Tasks from db, which ID's is equal to param
     * @param id Tasks's id to delete
     */
	void deleteTaskById(int id);
	
	  /**
     * Update Tasks
     * @param task Tasks object
     */
	void updateTask(Task task);
}
