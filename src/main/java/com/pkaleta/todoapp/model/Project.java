package com.pkaleta.todoapp.model;

import java.util.Date;

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
 * Project Entity definition
 *
 */


@Component
@Entity
@Table(name="Project")
public class Project {

	@Id
	@Column(name = "ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    @Column(name = "NAME", nullable = false)
	private String name;
	
    @Column(name = "COLOR", nullable = false)
	
    private String color;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
	
	@Column(name = "START")
	private Date start;
	
	@Column(name = "END")
	private Date end;
	
	@Column(name = "FAVOURITE", length=1)
	private boolean favourite;
	
	@Column(name = "DONE", length=1)
	private boolean done;
	
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getStart() {
		return start;
	}
	
	public void setStart(Date start) {
		this.start = start;
	}
	
	public Date getEnd() {
		return end;
	}
	
	public void setEnd(Date end) {
		this.end = end;
	}
	
	public boolean isFavourite() {
		return favourite;
	}
	
	public void setFavourite(boolean favourite) {
		this.favourite = favourite;
	}
	
	public boolean isDone() {
		return done;
	}
	
	public void setDone(boolean done) {
		this.done = done;
	}
	
	 @Override
	    public String toString() {
	        return "Project[id="+id+", name="+name+", description="+description+", color="+color+", start="+start+", end="+end+"[favourite="+favourite+", done="+done+"]]";
	    }
	
}
