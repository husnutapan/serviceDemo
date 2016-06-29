package com.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.model.Parent;
import com.model.Tuser;
import com.service.ParentService;

@Controller
public class ParentController {

	@Autowired
	private ParentService parentService;

	@RequestMapping(value = "/parent/", method = RequestMethod.GET)
	public ResponseEntity<Void> createUser(@RequestBody Parent parent, UriComponentsBuilder ucBuilder) {
		parentService.saveParent(parent);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/parent/{id}").buildAndExpand(parent.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Void> loginUser(@RequestParam Map<String, String> map) {
		System.out.println("geldi");
		Tuser tuser = new Tuser();
		tuser.setEmail(map.get("email"));
		tuser.setPassword(map.get("password"));
		System.out.println(map.get("email"));
		System.out.println(map.get("password"));
		System.out.println(parentService.loginUser(tuser));
		if (parentService.loginUser(tuser)) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
