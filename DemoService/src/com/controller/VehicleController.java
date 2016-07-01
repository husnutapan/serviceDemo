package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value = "/senddatafromhardware/", method = RequestMethod.POST, consumes = { "application/json" })
	public void catchRequestFromHardware(@RequestBody Vehicle vehicle) {
			vehicleService.saveVehicle(vehicle);
	}
}

/**
 * {
    "id":"5",
    "licensePlate":"06 HC 0612",
    "timeStamp":"2014-01-01",
    "vehicleCompany":"DummyCompany",
    "students":[{"id":"5","proximity":"4","parent":{"id":"1"},"vehicle":{"id":"5"}},{"id":"6","proximity":"2","parent":{"id":"1"},"vehicle":{"id":"5"}}],
    "location":[{"id":"10","enlem":"432423","boylam":"324234","speed":"90","vehicle":[{"id":"5"}]}]
}
 * 
 * 
 * 
 * 
 */


/*
 * private int id; private String licensePlate; private Date timeStamp; private
 * String vehicleCompany;
 * 
 * @OneToMany(mappedBy = "vehicle") private List<Student> students;
 * 
 * @ManyToMany
 * 
 * @JoinTable(name = "VEHICLE_LOCATION", joinColumns = @JoinColumn(name =
 * "VEHICLE_ID"), inverseJoinColumns = @JoinColumn(name = "LOCATION_ID"))
 * private List<Location> location;
 * 
 * json = { "version": 0.1, "releaseDate": "2016-06-29T00:00:00.000Z",
 * "VEHICLE": { "vehicleId": 12345, "vehiclePlate": "06 HC 2861 //That's my car"
 * , "vehicleCompany": "Dummy Company Inc.", "Position": { "latitude":
 * "37.031942 N // Location in Bodrum :)", "longtitude": "27.400546 E", "speed":
 * "90 kmph" }, "Passangers": [ { "UID": "12346789", "proximity": "1" }, {
 * "UID": "12346788", "proximity": "2" } ] } }
 */