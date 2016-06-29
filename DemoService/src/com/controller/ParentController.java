package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.model.Parent;
import com.service.ParentService;

@RestController
public class ParentController {
	
	@Autowired
	private ParentService parentService;

	@RequestMapping(value = "/parent/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Void> createUser(@RequestBody Parent parent, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Parent " + parent.getName());

		// SAVE PARENT
		parentService.saveParent(parent);
		

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/parent/{id}").buildAndExpand(parent.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

}
