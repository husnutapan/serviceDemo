package com.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "VEHICLE")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String licensePlate;
	private Date timeStamp;
	
	@OneToMany
	private List<Student> students;
	
	@OneToOne
	private Location location;

	public Vehicle() {
		
	}

	public Vehicle(String licensePlate, Date timeStamp, List<Student> students, Location location) {
		super();
		this.licensePlate = licensePlate;
		this.timeStamp = timeStamp;
		this.students = students;
		this.location = location;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getLicensePlate() {
		return licensePlate;
	}



	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}



	public Date getTimeStamp() {
		return timeStamp;
	}



	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}



	public List<Student> getStudents() {
		return students;
	}



	public void setStudents(List<Student> students) {
		this.students = students;
	}



	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	

}
