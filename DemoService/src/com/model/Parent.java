package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "PARENT")
public class Parent {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String surname;
	private String telNumber;
	private String email;

	@OneToMany
	private List<Student> students;

	public Parent() {
	}

	
	
	public Parent(String name, String surname, String telNumber, String email, List<Student> students) {
		super();
		this.name = name;
		this.surname = surname;
		this.telNumber = telNumber;
		this.email = email;
		this.students = students;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
