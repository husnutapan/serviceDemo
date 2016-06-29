package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.service.LocationService;

@RestController
public class LocationController {
	
	@Autowired
	private LocationService locationService;

}
