package com.pkaleta.todoapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pkaleta.todoapp.model.User;

@Repository("UserDAO")
public class UserDAOImpl extends AbstractDAO implements UserDAO {

	
	public void saveUser(User user) {
		persist(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		List<User> usersList = getSession().createQuery("from User").list();
    	return usersList;
	}

	public void deleteUserById(int id) {
		 getSession().createQuery("delete from User where id = :id").setParameter("id", id).executeUpdate();
		
	}

	public User findById(int id) {
        return  (User)getSession().createQuery("from User where id = :id").setParameter("id", id).uniqueResult();
	
	}

	public void updateUser(User user) {
	getSession().update(user);
		
	}

}
