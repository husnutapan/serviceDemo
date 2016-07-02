package com.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Parent;
import com.model.Student;
import com.model.Tuser;
import com.service.ParentService;
import com.service.StudentService;

@Controller
public class ParentController {

	@Autowired
	private ParentService parentService;

	@Autowired
	private StudentService studentService;

	// LOGIN WITH USERNAME AND PASSWORD
	@RequestMapping(value = "/login/", method = RequestMethod.POST, consumes = { "application/xml",
			"application/json" })
	public @ResponseBody ResponseEntity<HashMap<String, Integer>> loginUser(@RequestBody Tuser tuser) {
		HashMap<String, Integer> deger = new HashMap<>();
		if (parentService.loginUser(tuser)) {
			System.out.println("login basarili " + tuser.getEmail() + " ile...");
			Student student = studentService.getUIDWithTuser(tuser);
			System.out.println(student.getName());
			deger.put("uId", student.getParent().getId());
			deger.put("vehicleId", student.getVehicle().getId());
			return new ResponseEntity<HashMap<String, Integer>>(deger, HttpStatus.OK);
		}
		return new ResponseEntity<HashMap<String, Integer>>(deger, HttpStatus.NOT_FOUND);
	}

	// CREATE PARENT
	@RequestMapping(value = "/createParent/", method = RequestMethod.POST, consumes = { "application/json" })
	public @ResponseBody ResponseEntity<Void> createParent(@RequestBody Parent parent) {
		parentService.createParent(parent);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// DELETE PARENT
	@RequestMapping(value = "/deleteParent/{parentId}", method = RequestMethod.POST, consumes = { "application/json" })
	public @ResponseBody ResponseEntity<Void> deleteParent(@PathVariable("parentId") int parentId) {
		parentService.deleteParent(parentId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// UPDATE PARENT
	@RequestMapping(value = "/updateParent/", method = RequestMethod.POST, consumes = { "application/json" })
	public @ResponseBody ResponseEntity<Void> updateParent(@RequestBody Parent parent) {
		parentService.updateParent(parent);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}

/*
 * { "name":"Husnu", "surname":"TAPAN", "telNumber":"123456789",
 * "students":[{"name":"Mustafa","surname":"TAPAN","proximity":"0","vehicle_id":
 * "2"}],
 * "tuser":{"email":"husnu@gmail.com","password":"1234","token":"abcdefgh123"} }
 * 
 */
