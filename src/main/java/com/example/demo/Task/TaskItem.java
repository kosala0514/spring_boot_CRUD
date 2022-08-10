package com.example.demo.Task;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

@Entity
public class TaskItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private long id;
	
	@NotNull(message="Title is required!")
	private String title;
	private boolean done;
	
	public TaskItem() {
		super();
	}
	
	public TaskItem( String title) {
		super();
		this.title = title;
		this.done = false;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
	

	
	
	
}
