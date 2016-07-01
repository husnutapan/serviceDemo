package com.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

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

	private String vehicleCompany;

	@OneToMany(mappedBy = "vehicle")
	private List<Student> students;

	@ManyToMany
	@JoinTable(name = "VEHICLE_LOCATION", joinColumns = @JoinColumn(name = "VEHICLE_ID"), inverseJoinColumns = @JoinColumn(name = "LOCATION_ID"))
	private List<Location> location;

	public Vehicle() {

	}

	
	public Vehicle(String licensePlate, Date timeStamp, List<Student> students, Location location) {
		this.licensePlate = licensePlate;
		this.timeStamp = timeStamp;
		this.students = students;
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

	public String getVehicleCompany() {
		return vehicleCompany;
	}

	public void setVehicleCompany(String vehicleCompany) {
		this.vehicleCompany = vehicleCompany;
	}

	public List<Location> getLocation() {
		return location;
	}

	public void setLocation(List<Location> location) {
		this.location = location;
	}
}
