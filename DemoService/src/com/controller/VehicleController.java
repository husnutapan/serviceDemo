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

import com.model.Vehicle;
import com.service.VehicleService;

@RestController
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(value = "/vehicle/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Void> createUser(@RequestBody Vehicle vehicle, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Vehicle " + vehicle.getLicensePlate());

		// SAVE VEHICLE
		vehicleService.saveVehicle(vehicle);	

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/parent/{id}").buildAndExpand(vehicle.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
}
	
	
}

