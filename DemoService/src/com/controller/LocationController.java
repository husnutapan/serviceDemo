package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Location;
import com.model.Vehicle;
import com.service.LocationService;

@Controller
public class LocationController {
	@Autowired
	private LocationService locationService;

	@RequestMapping(value = "/location/{vehicleParam}", method = RequestMethod.POST, consumes = { "application/json" })
	public @ResponseBody ResponseEntity<List<Location>> getLocationListWithWehicleId( @PathVariable("vehicleParam") int vehicleParam) {
		
		List<Location> vehicleLocation = new ArrayList<>();
		vehicleLocation = locationService.getLocationsWithVehicleId(vehicleParam);
		

		return new ResponseEntity<List<Location>>(vehicleLocation, HttpStatus.OK);
	}
}
