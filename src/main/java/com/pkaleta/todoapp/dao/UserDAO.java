package com.pkaleta.todoapp.dao;

import java.util.List;
 
import com.pkaleta.todoapp.model.User;
 
/**
 * 
 * @author pkaleta
 *
 * Interface is connector between service and User object
 */
public interface UserDAO {
 
	/**
	 * Save user object in db
	 * @param user User object
	 */
    void saveUser(User user);
     
    /**
     * Get raw list of all User from db
     * @return List of Users
     */
    List<User> findAllUsers();
     
    /**
     * Delete User from db that ID's is equal to param
     * @param id User's id to delete
     */
    void deleteUserById(int id);
     
    /**
     * Look for User with ID that's equal to param
     * @param id User's id to find
     * @return User object
     */
    User findById(int id);
     
    /**
     * Update user
     * @param user User object
     */
    void updateUser(User user);
}