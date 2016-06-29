package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="LOCATION")
public class Location {
	
	@Id
	@GeneratedValue
	private int id;
	private String enlem;
	private String boylam;
	private int speed;
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
	
}
