package com.pkaleta.todoapp.dao;

import java.util.List;

import com.pkaleta.todoapp.model.Task;

/**
 * 
 * @author pkaleta
 *
 * Interface is connector between service and Task object
 */
public interface TaskDAO {

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
