package com.xadmin.SpringBootCrud.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // entity is used to the create a table with name "subject" in the database
@Table(name = "Appointment") // the table with name subject has 2 columns that are id and name
public class Appointment {

	@Id
	private String time;
	private String name;

	public Appointment() {

	}

	public Appointment(String time, String name) {
		super();
		this.time = time;
		this.name = name;
	}

	public String gettime() {
		return time;
	}

	public void settime(String time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
