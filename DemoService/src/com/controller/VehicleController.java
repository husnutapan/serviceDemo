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
		// vehicleService.saveVehicle(vehicle);
	}
}

/*
 * 
 * json = { "version": 0.1, "releaseDate": "2016-06-29T00:00:00.000Z",
 * "VEHICLE": { "vehicleId": 12345, "vehiclePlate": "06 HC 2861 //That's my car"
 * , "vehicleCompany": "Dummy Company Inc.", "Position": { "latitude":
 * "37.031942 N // Location in Bodrum :)", "longtitude": "27.400546 E", "speed":
 * "90 kmph" }, "Passangers": [ { "UID": "12346789", "proximity": "1" }, {
 * "UID": "12346788", "proximity": "2" } ] } }
 */