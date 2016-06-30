package com.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

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

	@RequestMapping(value = "/parent/", method = RequestMethod.GET)
	public ResponseEntity<Void> createUser(@RequestBody Parent parent, UriComponentsBuilder ucBuilder) {
		parentService.saveParent(parent);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/parent/{id}").buildAndExpand(parent.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

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

}
