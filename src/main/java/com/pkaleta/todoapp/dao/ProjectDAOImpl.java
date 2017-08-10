package com.pkaleta.todoapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pkaleta.todoapp.model.Project;

@Repository("ProjectDAO")
public class ProjectDAOImpl extends AbstractDAO implements ProjectDAO {

	public void saveProject(Project project) {
		persist(project);
	}

	@SuppressWarnings("unchecked")
	public List<Project> findAllUserProjects(int userID) {
		List<Project> projectList = getSession().createQuery("from Project p where p.user.id = :id").setParameter("id", userID).list();
    	return projectList;  	
	}

	public Project findProjectById(int id) {
		  return  (Project)getSession().createQuery("from Project where id = :id").setParameter("id", id).uniqueResult();
	}

	public void deleteProjectById(int id) {
		 getSession().createQuery("delete from Project where id = :id").setParameter("id", id).executeUpdate();
	}

	public void updateProject(Project project) {
		getSession().update(project);
		
	}


	}
