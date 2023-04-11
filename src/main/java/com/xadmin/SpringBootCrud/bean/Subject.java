package com.xadmin.SpringBootCrud.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // entity is used to the create a table with name "subject" in the database
@Table(name="Subject") // the table with name subject has 2 columns that are id and name
public class Subject {
	
	@Id
	private String id;
	private String name;
	
	public Subject() {
		
	}
	
	public Subject(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
