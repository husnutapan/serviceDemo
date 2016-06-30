package com.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Location;
import com.service.LocationService;

@Controller
public class LocationController {
	@Autowired
	private LocationService locationService;

	@RequestMapping(value = "/location/{Id}", method = RequestMethod.POST, consumes = { "application/xml",
			"application/json" })
	public @ResponseBody ResponseEntity<HashMap<String, Integer>> loginUser(@PathVariable int locationId) {
		ArrayList<Location> vehicleLocation = new ArrayList<>();
		return new ResponseEntity<HashMap<String, Integer>>(HttpStatus.OK);
	}
}
