package com.pkaleta.todoapp.services;

import static org.junit.Assert.*;


import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.pkaleta.todoapp.cfg.AppConfig;
import com.pkaleta.todoapp.model.User;
import com.pkaleta.todoapp.service.UserService;
import org.hamcrest.collection.IsEmptyCollection;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Autowired
	private User u;
	
		@Before
		public void setUp() {
			u.setUsername("Test User");
			u.setPassword("Test pass");
		}
		
	    @Test
	    public void testUser() {
	        assertNotNull(u);  
	        assertThat(u, IsInstanceOf.instanceOf(User.class));
	      
	    }
	    
	    @Transactional
	    @Test
	    public void testUserService() {
	    	userService.saveUser(u);
	    	userService.updateUser(u);
	    	assertThat(userService.findAllUsers(), not(IsEmptyCollection.empty()));
	    	assertThat(userService.findAllUsers(), hasItems(u));
	    	userService.deleteUserById(u.getId());
	    	

	    }
}