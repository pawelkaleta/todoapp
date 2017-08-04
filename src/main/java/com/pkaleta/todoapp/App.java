package com.pkaleta.todoapp;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.pkaleta.todoapp.cfg.AppConfig;
import com.pkaleta.todoapp.model.User;
import com.pkaleta.todoapp.service.UserService;

/**
 * @author pkaleta
 * 
 * Main app loop for TODO-APP application.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	 
    	 
         UserService userService = (UserService) context.getBean("userService");
         
         /*
          * Create User1
          */
         User user = new User();
         user.setUsername("First");
         user.setPassword("1st pass");
         
         /*
          * Create User2
          */
         
         User user2 = new User();
         user2.setUsername("Second");
         user2.setPassword("2nd pass");
  
         /*
          * Persist both Users
          */
         userService.saveUser(user);
         userService.saveUser(user2);
  
         /*
          * Get all users list from database
          */
         List<User> usersList = userService.findAllUsers();
         for (User u : usersList) {
             System.out.println(u);
         }
         
         /*
          * delete user
          */
         userService.deleteUserById(user2.getId()); // Well, the id is generated and set by the next one(right after previous - even if it's already deleted) 
  
         /*
          * update User
          */
  
         User userUpdate = userService.findById(user.getId());
         userUpdate.setUsername("Updated First");
         userService.updateUser(userUpdate);
  
         /*
          * Get all users list from db
          */
         List<User> userList = userService.findAllUsers();
         for (User u : userList) {
             System.out.println(u);
         }
         
         context.close();
    }
}
