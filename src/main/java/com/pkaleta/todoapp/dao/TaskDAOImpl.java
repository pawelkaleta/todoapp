package com.pkaleta.todoapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pkaleta.todoapp.model.Task;

@Repository("TaskDAO")
public class TaskDAOImpl extends AbstractDAO implements TaskDAO {

	public void saveTask(Task task) {
		persist(task);
	}

	@SuppressWarnings("unchecked")
	public List<Task> findAllProjectTasks(int projectID) {
		List<Task> taskList = getSession().createQuery("from Task t where t.project.id = :id").setParameter("id", projectID).list();		
    	return taskList;
	}

	public Task findTaskById(int id) {
		return  (Task)getSession().createQuery("from Task where id = :id").setParameter("id", id).uniqueResult();
	}

	public void deleteTaskById(int id) {
		 getSession().createQuery("delete from Task where id = :id").setParameter("id", id).executeUpdate();		
	}

	public void updateTask(Task task) {
		getSession().update(task);
	}

}
