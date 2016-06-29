package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Vehicle;
import com.service.VehicleService;

@Controller
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;

	
	@RequestMapping(value = "/vehicle", method = RequestMethod.GET)
	public void createVehicle() {
		System.out.println("saving vehicle");
		// SAVE VEHICLE
	//	vehicleService.saveVehicle(vehicle);
	}
}
