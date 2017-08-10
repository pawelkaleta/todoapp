package com.pkaleta.todoapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


/**
 * 
 * @author pkaleta
 *
 * User entity definition
 */
@Component
@Entity
@Table(name="USER")
public class User {
 
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "USERNAME", nullable = false)
    private String username;
 

 
	@Column(name = "PASSWORD", nullable = false)
    private String password;
 
   
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String name) {
        this.username = name;
    }
 
    public String getPassword() {
  		return password;
  	}

  	public void setPassword(String password) {
  		this.password = password;
  	}
  	
  	/**
  	 * Override toString method just for testing
  	 */
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password+" ]";
    }
     
     
}