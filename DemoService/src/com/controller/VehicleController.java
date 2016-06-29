package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.service.VehicleService;

@RestController
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;
}
