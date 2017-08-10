package com.pkaleta.todoapp.dao;

import java.util.List;

import com.pkaleta.todoapp.model.Project;

/**
 * 
 * @author pkaleta
 *
 * Interface is connector between service and Project object
 */
public interface ProjectDAO {

	/**
	 * Save project object in db
	 * @param project Project object
	 */
	void saveProject(Project project);
	
	
	/**
     * Get raw list of all Projects from db by User id
     * @return List of Projects
     */
	List<Project> findAllUserProjects(int userID);
	
	
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
}
