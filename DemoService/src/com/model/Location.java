package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "LOCATION")
public class Location {

	@Id
	@GeneratedValue
	private int id;
	private String enlem;
	private String boylam;
	private int speed;

	@ManyToMany(mappedBy="location")
	private List<Vehicle> vehicle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnlem() {
		return enlem;
	}

	public void setEnlem(String enlem) {
		this.enlem = enlem;
	}

	public String getBoylam() {
		return boylam;
	}

	public void setBoylam(String boylam) {
		this.boylam = boylam;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	

}
