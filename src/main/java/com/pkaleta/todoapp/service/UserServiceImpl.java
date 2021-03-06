package com.pkaleta.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.pkaleta.todoapp.dao.UserDAO;
import com.pkaleta.todoapp.model.User;
 
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
 
    @Autowired
    private UserDAO dao;

	public void saveUser(User user) {
		dao.saveUser(user);
		
	}

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	public void deleteUserById(int id) {
		dao.deleteUserById(id);
		
	}

	public User findById(int id) {
		return dao.findById(id);
	}

	public void updateUser(User user) {
		dao.updateUser(user);
	}
     

}